#ifndef CGAMEOBJ_H
#define CGAMEOBJ_H

#include "CGameMap.h"


namespace game_framework {

	class CGameObj
	{
	public:
		CGameObj();
		CGameObj(const CGameObj& other);
		virtual ~CGameObj();

		// �P�_
		bool Collision(CGameObj*);		// ����I��
		bool Collision(CGameMap*, CGameMap::MapContent = CGameMap::MapContent::WALL);		// �a�ϸI��
		bool IsEnable();				// �O�_�ҥ�
		bool NeedFree();				// �O�_����
		bool IsDie();					// �O�_���`
		bool IsMoveing();

		// Getter
		int GetX1();					// ���W�a���I�y��
		int GetY1();					
		virtual int GetX2();			// �k�U�a���I�y��
		virtual int GetY2();
		double GetVectorX();			// ������V
		double GetVectorY();
		int GetShowPriority();			// ��������u����
		string GetTag();

		// Setter
		void SetEnable(bool);
		void SetFree(bool);
		void SetDie(bool);
		void SetVector(double, double);
		void SetMovingDown(bool flag);	
		void SetMovingLeft(bool flag);	
		void SetMovingRight(bool flag); 
		void SetMovingUp(bool flag);	
		void SetShowPriority(int);
		void SetXY(int, int);
		void SetSpeed(int);
		void SetHp(int);
		void SetMaxHp(int);
		void SetTag(string);
		
		// member function
		void LoadBitmap(int);
		virtual void LoadBitmap() {};
		virtual void OnShow(CGameMap*);				// �b�a����ܪ���
		virtual void OnMove(CGameMap*);
		virtual void OnObjCollision(CGameObj*) {};
		virtual void OnDie() {};					// ���`�ݰ�
		virtual void OnKeyUp(char);
		virtual void OnKeyDown(char);
		virtual void Reset();
		virtual void TakeDmg(int);
		double Distance(CGameObj*);
		int CenterX();
		int CenterY();

		// operator
		CGameObj& operator=(const CGameObj& other);

	protected:
		vector<CAnimation> _animas;						//	�ʵe�M��
		vector<CAnimation>::iterator _animaIter;		//	vector iterator
		int _mx, _my, _moveSpeed;						//	�a���I�y�СB���ʳt��
		int _showPriority;								//	����u��
		int _hp, _maxHp;								//	��q�ȡB�̤j��q��
		double _vector[2];								//	���ʡB��V�P�O�ΦV�q
		bool _isEnable, _needFree, _isDie;				//	�O�_�ҥΡB����B���`
		bool _isMovingDown;								//	�O�_���b���U����
		bool _isMovingLeft;								//	�O�_���b��������
		bool _isMovingRight;							//	�O�_���b���k����
		bool _isMovingUp;								//	�O�_���b���W����
		string _tag;									//	TAG


	private:
		bool HitRectangle(int tx1, int ty1, int tx2, int ty2);
		void copy(const CGameObj&);
	};
}

#endif