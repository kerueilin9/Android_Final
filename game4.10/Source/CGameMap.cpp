#include "stdafx.h"
#include "Resource.h"
#include <mmsystem.h>
#include <ddraw.h>
#include "audio.h"
#include "gamelib.h"
#include "CGameMap.h"


namespace game_framework {
	CGameMap::CGameMap()
		:_MAPW(25), _MAPH(25), _MAXNOFROOM(5)
	{
		// �ʵe���J
		const int AnimaSize = 4;
		_animas.reserve(AnimaSize);
		for (int i = 0; i < AnimaSize; i++)
			_animas.push_back(CAnimation());

		_Rooms = nullptr;

		Reset();
	}

	CGameMap::~CGameMap()
	{
		free();
	}

	void CGameMap::Reset()
	{
		_sx = _sy = 0;
		for (int i = 0; i < 200; i++)
		{
			for (int j = 0; j < 200; j++)
			{
				_map[i][j] = MapContent::NULLPTR;
			}
		}
		_animaIterator = _animas.begin();

		free();
		_Rooms = new CGameMap::RoomData*[_MAXNOFROOM];
		for (int i = 0; i < _MAXNOFROOM; i++)
			_Rooms[i] = new CGameMap::RoomData[_MAXNOFROOM];
	}

	void CGameMap::free()
	{
		if (_Rooms != nullptr)
		{
			for (int i = 0; i < _MAXNOFROOM; i++)
					delete[] _Rooms[i];
			delete[] _Rooms;
			_Rooms = nullptr;
		}
	}

	void CGameMap::LoadBitmap()
	{
		_animaIterator = GetAnima(MapContent::NULLPTR);
		_animaIterator->AddBitmap(IDB_FLOOR_1, RGB(255, 255, 255));
		_animaIterator = GetAnima(MapContent::FLOOR);
		_animaIterator->AddBitmap(IDB_FLOOR_1, RGB(255, 255, 255));
		_animaIterator = GetAnima(MapContent::WALL);
		_animaIterator->AddBitmap(IDB_WALL_1, RGB(255, 255, 255));
		_animaIterator = GetAnima(MapContent::AISLEWALL);
		_animaIterator->AddBitmap(IDB_WALL_1, RGB(255, 255, 255));
		_animaIterator = _animas.begin();
	}

	void CGameMap::OnMove(int px, int py)
	{
		//	�ʵe����
		for (int i = 0; i < (int)_animas.size(); i++)
			_animas.at(i).OnMove();
			
		//	�ù����H����
		this->SetScreen(px - (SIZE_X>>1), py - (SIZE_Y>>1));
	}

	void CGameMap::OnShow()
	{
		for (int i = 0; i < 200; i++)
		{
			for (int j = 0; j < 200; j++)
			{
				int mx = _MAPW * i, my = _MAPH * j;
				if ((this->InScreen(mx, my, mx + _MAPW, my + _MAPH)) && _map[i][j] != MapContent::NULLPTR)
				{
					_animaIterator = GetAnima(_map[i][j]);
					_animaIterator->SetTopLeft(ScreenX(mx), ScreenY(my));
					_animaIterator->OnShow();
				}
			}
		}
	}

	void CGameMap::GenerateMap()
	{
		Reset();
		
		const int INTERNAL = 35;
		const int NROOMS = _MAXNOFROOM - 1;
		/*int Room[NROOMS][NROOMS][2];
		bool mask[NROOMS][NROOMS];
		memset(mask, false, sizeof(mask));*/

		//	�M�w�ж����L
		int rx = 2 + (rand() % (NROOMS - 1));
		for (int i = 0; i < rx; i++)
		{
			int ry = 1 + (rand() % (NROOMS));
			for (int j = 0; j < ry; j++)
			{
				_Rooms[i][j].__hasRoom = true;
			}
		}

		//	�M�w�ж��e���B�]�w���߰ϰ�
		for (int i = 0; i < NROOMS; i++)
		{
			for (int j = 0; j < NROOMS; j++)
			{
				if (!_Rooms[i][j].HasRoom())
					continue;
				int height = 15 + (rand() % 5) * 2, weight = 15 + (rand() % 5) * 2;// ���������魫QQ ���ӬO�e��
				int orgx = (INTERNAL >> 1) + INTERNAL * i - (height >> 1);
				int orgy = (INTERNAL >> 1) + INTERNAL * j - (weight >> 1);
				// ��l�Ʃж��Ѽ�
				_Rooms[i][j].__width = height; 
				_Rooms[i][j].__high = weight;
				_Rooms[i][j].__centerX = (INTERNAL >> 1) + INTERNAL * i;
				_Rooms[i][j].__centerY = (INTERNAL >> 1) + INTERNAL * j;
				for (int x = 0; x < height; x++)
				{
					for (int y = 0; y < weight; y++)
					{
						_map[orgx + x][orgy + y] = MapContent::FLOOR;
					}
				}

				for (int x = 0; x < height; x++)
				{
					_map[orgx + x][orgy - 1] = MapContent::WALL;
					_map[orgx + x][orgy + weight] = MapContent::WALL;
				}

				for (int y = -1; y < weight + 1; y++)
				{
					_map[orgx - 1][orgy + y] = MapContent::WALL;
					_map[orgx + height][orgy + y] = MapContent::WALL;
				}

			}
		}

		//	�]�w�ж��������q�D
		for (int i = 0; i < NROOMS; i++)
		{

			for (int j = 0; j < NROOMS; j++)
			{
				if (_Rooms[i][j].HasRoom() == false)
					continue;
				int h1 = _Rooms[i][j].__width, h2; // �e���n���ΤϤF
				int w1 = _Rooms[i][j].__high, w2;
				int cx = _Rooms[i][j].__centerX;
				int cy = _Rooms[i][j].__centerY;
				if (_Rooms[i + 1][j].HasRoom() && (i + 1) != NROOMS) {
					_Rooms[i][j].__hasRoad[3] = true;
					_Rooms[i + 1][j].__hasRoad[2] = true;
					h2 = _Rooms[i + 1][j].__width;
					w2 = _Rooms[i + 1][j].__high;
					// �D�q�D
					for (int x = cx + h1 / 2 + 1 ; x < cx + INTERNAL - h2 / 2; x++)
					{
						_map[x][cy + 3] = MapContent::WALL;
						_map[x][cy - 3] = MapContent::WALL;
						for (int y = -2; y < 3; y++)
						{
							_map[x][cy + y] = MapContent::FLOOR;
						}
					}
					// �i�ж��Ϲj
					for (int y = -2; y < 3; y++) {
						_map[cx + h1 / 2 + 1][cy + y] = MapContent::AISLEWALL;
						_map[cx + INTERNAL - h2 / 2 - 1][cy + y] = MapContent::AISLEWALL;
					}
				}
				if (_Rooms[i][j + 1].HasRoom() && (j + 1) != NROOMS) {
					_Rooms[i][j].__hasRoad[1] = true;
					_Rooms[i][j + 1].__hasRoad[0] = true;
					h2 = _Rooms[i][j + 1].__width;
					w2 = _Rooms[i][j + 1].__high;
					for (int y = cy + w1 / 2 + 1; y < cy + INTERNAL - w2 / 2; y++)
					{
						_map[cx + 3][y] = MapContent::WALL;
						_map[cx - 3][y] = MapContent::WALL;
						for (int x = -2; x < 3; x++)
						{
							_map[cx + x][y] = MapContent::FLOOR;
						}
					}
					for (int x = -2; x < 3; x++)
					{
						_map[cx + x][cy + w1 / 2 + 1] = MapContent::AISLEWALL;
						_map[cx + x][cy + INTERNAL - w2 / 2 - 1] = MapContent::AISLEWALL;
					}
				}
			}
		}
	}

	void CGameMap::OnKeyUp(char nChar)
	{

	}

	void CGameMap::OnKeyDown(char nChar)
	{

	}

	int CGameMap::ScreenX(int x)
	{
		return x - _sx;
	}

	int CGameMap::ScreenY(int y)
	{
		return y - _sy;
	}

	bool CGameMap::IsContent(int x, int y, CGameMap::MapContent content)
	{
		x /= _MAPW;
		y /= _MAPH;
		return _map[x][y] == content;
	}

	bool CGameMap::InScreen(int x, int y, int mw, int mh)
	{
		int x1 = _sx;
		int y1 = _sy;
		int x2 = x1 + SIZE_X;
		int y2 = y1 + SIZE_Y;
		return (mw >= x1 && x <= x2 && mh >= y1 && y <= y2);
	}

	void CGameMap::SetScreen(int x, int y)
	{
		_sx = x;
		_sy = y;
	}

	vector<CAnimation>::iterator CGameMap::GetAnima(MapContent Type)
	{
		vector<CAnimation>::iterator iterator;
		switch (Type)
		{
		case game_framework::CGameMap::MapContent::NULLPTR:
			iterator = _animas.begin();
			break;
		case game_framework::CGameMap::MapContent::FLOOR:
			iterator = _animas.begin() + 1;
			break;
		case game_framework::CGameMap::MapContent::WALL:
			iterator = _animas.begin() + 2;
			break;
		case game_framework::CGameMap::MapContent::AISLEWALL:
			iterator = _animas.begin() + 3;
			break;
		default:
			ASSERT(0);
		}
		return iterator;
	}

	int CGameMap::GetScreenX()
	{
		return _sx;
	}

	int CGameMap::GetScreenY()
	{
		return _sy;
	}


	// CGameMap ���� class
	CGameMap::RoomData::RoomData()
	{
		__centerX = 0;
		__centerY = 0;
		__width = __high = 1;
		__hasRoad[0] = __hasRoad[1] = __hasRoad[2] = __hasRoad[3] = false;
		__hasRoom = false;
	}

	bool CGameMap::RoomData::HasRoom()
	{
		return __hasRoom;
	}

	int CGameMap::RoomData::CenterX()
	{
		return __centerX;
	}

	int CGameMap::RoomData::CenterY()
	{
		return __centerY;
	}

	int CGameMap::RoomData::Width()
	{
		return __width;
	}

	int CGameMap::RoomData::High()
	{
		return __high;
	}

}