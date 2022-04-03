#include "stdafx.h"
#include "Resource.h"
#include <mmsystem.h>
#include <ddraw.h>
#include "audio.h"
#include "gamelib.h"
#include "CGameObjCenter.h"


namespace game_framework
{
	CGameObjCenter::CGameObjCenter()
	{
		init();
	}

	CGameObjCenter::~CGameObjCenter()
	{
		freeObj();
	}

	void CGameObjCenter::init()
	{
		_allObj.reserve(1024);
		_temp.reserve(1024);
	}

	void CGameObjCenter::OnMove(CGameMap* map)
	{
		// �[�J����
		for (CGameObj* obj : _temp)
			_allObj.push_back(obj);
		std::sort(_allObj.begin(), _allObj.end(),
			[](CGameObj* a, CGameObj* b)
		{
			return a->GetShowPriority() < b->GetShowPriority();
		});
		_temp.clear();

		// �R������
		for (int i = 0; i < (int)_allObj.size(); i++)
		{
			if (!_allObj.at(i)->IsEnable() && !_allObj.at(i)->IsDie())
			{
				delete _allObj.at(i);
				_allObj.erase(_allObj.begin() + i);
			}
		}

		// ���ʡB�s�W����
		for (int i = 0; i < (int)_allObj.size(); i++)
		{
			CGameObj* obj = _allObj.at(i);
			if (obj->IsEnable())
			{
				obj->OnMove(map);
			}
			else if(obj->IsDie())
			{
				obj->OnDie();
			}
		}
		
		// �B�z�I��
		for (int i = 0; i < (int)_allObj.size(); i++)
		{
			if (!_allObj.at(i)->IsEnable())
				continue;
			for (int j = i + 1; j < (int)_allObj.size(); j++)
				if (_allObj.at(j)->IsEnable() && _allObj.at(i)->Collision(_allObj.at(j)))
				{
					_allObj.at(i)->OnObjCollision(_allObj.at(j));
					_allObj.at(j)->OnObjCollision(_allObj.at(i));
				}
		}
			
				
	}

	void CGameObjCenter::OnShow(CGameMap* map)
	{
		for (CGameObj* obj : _allObj)
		{
			if(map->InScreen(obj->GetX1(), obj->GetY1(), obj->GetX2(), obj->GetY2()))
				obj->OnShow(map);
		}
	}

	void CGameObjCenter::FreeALLObj()
	{
		freeObj();
	}

	void CGameObjCenter::freeObj()
	{
		for (CGameObj* p : _allObj)
		{
			if (p->NeedFree())
			{
				delete p;
			}
		}
		_temp.clear();
		_allObj.clear();
	}


	vector<CGameObj*> CGameObjCenter::_allObj, CGameObjCenter::_temp;
}