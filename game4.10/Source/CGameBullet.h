#pragma once
#include "CGameObj.h"

namespace game_framework
{
	class CGameBullet : public CGameObj
	{
	public:
		CGameBullet();

		void SetTarget(string);
		void SetDamage(int);

		void LoadBitmap();
		void OnMove(CGameMap* map);
		//void OnShow(CGameMap* map);
		void OnObjCollision(CGameObj*);

	protected:
		int _damage;		//�l�u�����O
		string _target;

	private:
		
		void init();
	};

}
