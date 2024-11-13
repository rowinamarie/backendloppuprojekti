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
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    KayttajaRepository kayttajaRepository;

    @Override
    public UserDetails loadUserByUsername(String kayttajatunnus) throws UsernameNotFoundException {
        Kayttaja nykyinenkayttaja = kayttajaRepository.findByKayttajatunnus(kayttajatunnus);
        System.out.println("Haetaan käyttäjää käyttäjänimellä: " + kayttajatunnus);

        // Tarkista, onko käyttäjää löydetty
        if (nykyinenkayttaja == null) {
            // Tulosta virheilmoitus ja heitä poikkeus
            System.out.println("Käyttäjää ei löytynyt: " + kayttajatunnus);
            throw new UsernameNotFoundException("Käyttäjää ei löytynyt: " + kayttajatunnus);
        }
        UserDetails kayttaja = new org.springframework.security.core.userdetails.User(kayttajatunnus,
                nykyinenkayttaja.getSalasanaHash(),
                AuthorityUtils.createAuthorityList(nykyinenkayttaja.getRole()));
        return kayttaja;
    }

}
