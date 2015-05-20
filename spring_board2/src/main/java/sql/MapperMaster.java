package sql;

import java.util.ArrayList;

import com.jdk.vo.*;

public interface MapperMaster {
	
	//ȸ������
    void memberInsert(MemberVO memverVO);	//����
    MemberVO memberSelect(MemberVO memverVO); //�α���
    MemberVO memberIDFind(MemberVO memverVO); //ȸ��ã��
    void deleteMember(String user_Id);			//Ż��

    //�Խ��� ����
    BoardVO boardSelect(BoardVO boardvo);	//�۸��
    int boardSelectCount(BoardVO boardvo);	//�۰Լ�
    BoardVO boardView(BoardVO boardvo);		//�ۺ���
    void boardWriteInsert(BoardVO boardvo); //�۾���
    void boardViewCount(BoardVO boardvo);	//��ȸ������
    void boardUpdate(BoardVO boardvo);		//�ۼ���
    void boardDelete(BoardVO boardvo);		//�ۻ���
}
