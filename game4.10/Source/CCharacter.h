#pragma once
#include "CGameObj.h"
#include "CGameWeapon.h"
#include "CGameObjCenter.h"

namespace game_framework {

	class CCharacter : public CGameObj
	{
	public:
		enum class Anima {INIT_R, INIT_L, RUN_R, RUN_L, DIE};	//�ʵe����
		CCharacter();

		void TakeDmg(int);
		void LoadBitmap();				// ���J�ϧ�
		void OnShow(CGameMap*);			// �N�ϧζK��e��
		void OnMove(CGameMap*);			// ����
		void OnDie();
		void OnObjCollision(CGameObj*);
		void OnKeyUp(char);				
		void OnKeyDown(char);		
		void Reset();					// ���m���A

	
	protected:
		const int _ATTDELAY;						// ��ԧ������j
		int DT;										// direction �¦V���� 1 �¥k 0 �¥�
		int _mp, _maxMp, _shield, _maxShield;		// �]�O�ȡB�̤j�]�O�ȡB�@�ޡB�̤j�@�ޭ�
		int _damage;								// ��Զˮ`
		bool _doFire;								// �g���P�_
		bool _canAttack;							// ��ԧ����P�_
		vector<CGameWeapon> _weapon;				// �i�֦�2��Z��
		vector<CGameWeapon>::iterator _nowWeapon;	// ��e�Z��

	private:
		int _attCounter;				// ��ԭp�ƾ�
		int _deathCounter;				// ���`�˼�
		void free();
		void ModifyVector(int index, int plus);
		vector<CAnimation>::iterator GetAnima(Anima);	// ���o�ʵe
		
	};
}