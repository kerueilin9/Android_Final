#pragma once
#include "CGameObj.h"
#include "CGameBullet.h"


namespace game_framework
{
	class CGameWeapon : public CGameObj
	{
	public:
		enum class Anima { Right, Left };	// �ʵe����

		CGameWeapon();
		//CGameWeapon(const CGameWeapon&);

		bool CanFire();						// �Z���O�_�i�g��

		void SetTarget(string);
		void SetAttributes(int atk, int cost, int bulletSpeed, int shootDelay);

		void LoadBitmap();
		void OnMove(CGameMap* map);
		void OnShow(CGameMap* map);
		//void Shoot(CGameMap*, CGameObj*);	//	�ȮɨS��
		void Shoot(double, double);			//	�Z���g��
		void SetDT(int);					//	�ھڴ¦V���ʵe		

		//CGameWeapon& operator=(const CGameWeapon&);

	protected:
		bool _fire;
		int _cost, _bulletSpeed, _shootDelay;		//	�����O�B���ӯ�q�B�l�u�t�סB�����t��
		int _fireCounter;					//	�g������p��
		int _DT;							//	�ʵe�P�_
		CGameBullet _bullet;				//	�l�u�]�w
						

	private:
		void copy(const CGameWeapon&);
		vector<CAnimation>::iterator GetAnima(Anima);	// ���o�ʵe

	};
}
