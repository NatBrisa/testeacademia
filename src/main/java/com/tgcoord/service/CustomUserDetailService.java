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

    @Autowired
    public CustomUserDetailService(GestorRepository gestRep, FuncionarioRepository funcRep) {
        this.gestRep = gestRep;
        this.funcRep = funcRep;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        //O username é o próprio RG do Funcionario/Gestor
        
        Funcionario func = Optional.ofNullable(funcRep.findByRg(username)).orElseThrow(()-> new UnsupportedOperationException("RG inválido."));
        System.out.println("Funcionari0: ");
        
        Optional<Gestor> gest = gestRep.findById(func.getId());
        System.out.println("Gestor: " + gest.toString());
        
        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");               List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
        
        //Se for gestor ele terá acesso admin, se não, terá apenas acesso user
        return new User(func.getRg(), func.getSenha(), gest.isPresent() ? authorityListAdmin : authorityListUser);
    }
    
}
