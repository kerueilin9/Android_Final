#include "CGameObj.h"
namespace game_framework {

	class CInitialPlayer : public CGameObj
	{
	public:
		CInitialPlayer();

		void Initialize();				// �]�w��l��
		void LoadBitmap();				// ���J�ϧ�

	protected:
		CAnimation animation;		//�ʵe
	};
}