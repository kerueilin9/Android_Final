#pragma once
#include <algorithm>
#include "CGameObj.h"

namespace game_framework
{
	class CGameObjCenter
	{
	public:
		CGameObjCenter();
		~CGameObjCenter();

		void OnMove(CGameMap* map);
		void OnShow(CGameMap* map);
		void FreeALLObj();				// ��������񪺪���

		static void CGameObjCenter::AddObj(CGameObj* obj)	// �N����[�J,���u���Ŵ��J
		{
			//CGameObjCenter::_allObj.push_back(obj);
			/*CGameObjCenter::_allObj.insert(lower_bound(_allObj.begin(), _allObj.end(), obj,
				[](CGameObj* a, CGameObj* b)
				{
					return a->GetShowPriority() < b->GetShowPriority();
				}
			), obj);*/
			_temp.push_back(obj);
		}

		template<typename condition>	// �̱���M���Ӫ���
		static CGameObj* FindObjBy(condition function)
		{
			for (CGameObj* obj : _allObj)
			{
				if (function(obj))
					return obj;
			}
			return nullptr;
		}

		template<typename condition>	// �̱���M��h�Ӫ���
		static vector<CGameObj*> FindObjsBy(condition function)
		{
			vector<CGameObj*> objs;
			objs.reserve(_allObj.capacity());
			for (CGameObj* obj : _allObj)
			{
				if (function(obj))
					objs.push_back(obj);
			}
			return objs;
		}

		template<typename compare>	//	�̤���禡���̲ŦX����
		static vector<CGameObj*> FindMaxObjBy(compare cmp)
		{
			CGameObj* maxObj = _allObj.begin();
			for (CGameObj* obj : _allObj)
			{
				if (cmp(maxObj, obj))
					maxObj = obj;
			}
			return maxObj;
		}

	protected:

	private:
		static vector<CGameObj*> _allObj;
		static vector<CGameObj*> _temp;
		void init();
		void freeObj();
		
	};
	
}
