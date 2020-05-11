/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.service;

import com.tgcoord.model.Funcionario;
import com.tgcoord.model.Gestor;
import com.tgcoord.repository.FuncionarioRepository;
import com.tgcoord.repository.GestorRepository;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author natal
 */
@Service
public class CustomUserDetailService implements UserDetailsService {
    
    private final GestorRepository gestRep;
    
    private final FuncionarioRepository funcRep;

    /**
     *
     * @param gestRep
     * @param funcRep
     */
    @Autowired
    public CustomUserDetailService(GestorRepository gestRep, FuncionarioRepository funcRep) {
        super();
        this.gestRep = gestRep;
        this.funcRep = funcRep;
    }

    @Override
    public final UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        //O username é o próprio E-mail do Funcionario/Gestor
        Funcionario funcUser = Optional.ofNullable(funcRep.findByRg(username)).orElseThrow(()-> new UnsupportedOperationException("RG inválido."));
        System.out.println("Funcionario: " + funcUser.toString());
        
        Optional<Gestor> gest = gestRep.findById(funcUser.getId());
        System.out.println("Gestor: " + gest.toString());
        
        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
        
        //Se for gestor ele terá acesso admin, se não, terá apenas acesso user
//        return new User(func.getRg(), func.getSenha(), gest.isPresent() ? authorityListAdmin);

        if(gest.isEmpty()) {
            return new User(funcUser.getRg(), funcUser.getRg(), authorityListUser);
        } else {
            return new User(funcUser.getRg(), funcUser.getRg(), authorityListAdmin);
        }
    }
    private static final Logger LOG = Logger.getLogger(CustomUserDetailService.class.getName());
    
}
