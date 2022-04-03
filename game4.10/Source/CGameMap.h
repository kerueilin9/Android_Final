#pragma once
#include "CGameRoom.h"

namespace game_framework {
	class CGameMap
	{
	public:
		enum class MapContent {NULLPTR, FLOOR, WALL, AISLEWALL};		//�a�Ϥ��e��
		class RoomData
		{
		friend class CGameMap;
		public:
			RoomData();
			bool HasRoom();
			int CenterX();
			int CenterY();
			int Width();
			int High();
		protected:
			bool __hasRoom;				// ���ж�
			bool __hasRoad[4];			// �W�U���k���q�D
			int __centerX, __centerY;	// ���ߦ�m
			int __width, __high;		// �e��
		};
		CGameMap();
		~CGameMap();
		void LoadBitmap();
		int ScreenX(int x);				//	�a���I�y�Цb�ù���m
		int ScreenY(int y);
		bool InScreen(int x, int y, int mw, int mh);	// �y�нd��b�ù���
		bool IsContent(int x, int y, CGameMap::MapContent = MapContent::FLOOR);

		int GetScreenX();
		int GetScreenY();

		void SetScreen(int x, int y);	

		void OnMove(int x, int y);
		void OnShow();
		void OnKeyUp(char nChar);
		void OnKeyDown(char nChar);
		void GenerateMap();				//	�ͦ��a��
		void Reset();

	protected:
		MapContent _map[200][200];						// �a�ϨC�椺�e 200 X 200
		int _sx, _sy, _moveSpeed;						// �ù��I�y�СB���ʳt��			
		vector<CAnimation> _animas;						// �a�ϹϤ�
		vector<CAnimation>::iterator _animaIterator;	// �ާ@��
		const int _MAPW, _MAPH;							// �a�ϨC��e��
		const int _MAXNOFROOM;							// �̤j�ж��� _MAXNOFROOM * _MAXNOFROOM
		RoomData** _Rooms;
		
	
	private:
		void free();
		vector<CAnimation>::iterator GetAnima(MapContent);
	};
}