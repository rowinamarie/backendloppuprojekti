package loppuprojekti24.loppuprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import loppuprojekti24.loppuprojekti.domain.Kayttaja;
import loppuprojekti24.loppuprojekti.domain.KayttajaRepository;


@Service
public class KayttajaServiceImpl implements UserDetailsService {

    	@Autowired
	    KayttajaRepository kayttajaRepository;

        @Override
        public UserDetails loadUserByUsername(String kayttajanimi) throws UsernameNotFoundException {

            Kayttaja currentKayttaja = kayttajaRepository.findByKayttajanimi(kayttajanimi);
            UserDetails kayttaja = new org.springframework.security.core.userdetails.User(kayttajanimi, currentKayttaja.getSalasanaHash(), 
                    AuthorityUtils.createAuthorityList(currentKayttaja.getRooli()));
            return kayttaja;
        }   

}
