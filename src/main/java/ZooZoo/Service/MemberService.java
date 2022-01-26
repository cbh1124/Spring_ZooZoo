package ZooZoo.Service;

import ZooZoo.domain.DTO.MemberDTO;
import ZooZoo.domain.Entity.MemberEntity;
import ZooZoo.domain.Entity.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    // 회원가입
    public boolean SignUp(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.builder()
                .mid(memberDTO.getMid())
                .mpw(memberDTO.getMpw())
                .mname(memberDTO.getMname())
                .memail(memberDTO.getMemail())
                .mbirth(memberDTO.getMbirth())
                .maddress(memberDTO.getMaddress())
                .build();
        memberRepository.save(memberEntity);
        return true;
    }

    // 회원 아이디 찾기
    public String findpw(String mid, String memail) {
        List<MemberEntity> memberEntities = memberRepository.findAll();
        for (MemberEntity memberEntity : memberEntities) {
            if (memberEntity.getMid().equals(mid) && memberEntity.getMemail().equals(memail)) {
                return memberEntity.getMpw();
            }
        }
        return null;
    }
}
