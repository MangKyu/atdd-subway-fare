package nextstep.member.application;

import nextstep.member.domain.Member;
import nextstep.member.domain.MemberRepository;
import org.springframework.stereotype.Service;
import nextstep.subway.domain.LoginUser;
import support.auth.userdetails.UserDetails;
import support.auth.userdetails.UserDetailsService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private MemberRepository memberRepository;

    public CustomUserDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        Member member = memberRepository.findByEmail(email).orElseThrow(RuntimeException::new);
        return new LoginUser(member.getEmail(), member.getPassword(), member.getAge(), member.getRoles());
    }
}
