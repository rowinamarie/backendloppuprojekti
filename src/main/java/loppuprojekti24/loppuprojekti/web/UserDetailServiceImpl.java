package loppuprojekti24.loppuprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import loppuprojekti24.loppuprojekti.domain.Kayttaja;
import loppuprojekti24.loppuprojekti.domain.KayttajaRepository;

public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    KayttajaRepository kayttajaRepository;

    @Override
    public UserDetails loadUserByUsername(String kayttajatunnus) throws UsernameNotFoundException {
        Kayttaja nykyinenkayttaja = kayttajaRepository.findByKayttajatunnus(kayttajatunnus);
        UserDetails kayttaja = new org.springframework.security.core.userdetails.User(kayttajatunnus, nykyinenkayttaja.getSalasanaHash(),
                AuthorityUtils.createAuthorityList(nykyinenkayttaja.getRole()));
        return kayttaja;
    }

}
