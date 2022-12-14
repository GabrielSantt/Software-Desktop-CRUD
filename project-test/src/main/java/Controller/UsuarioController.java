/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Conn.JPA;
import DAO.UsuarioDAO;
import View.AtualizarCadastro;
import View.CadastroUsuario;
import View.TelaPrincipal;
import java.util.List;
import javax.persistence.EntityManager;
import model.Usuario;

/**
 *
 * @author GabrielSantos
 */
public class UsuarioController {

    private CadastroUsuario telaCadastro;
    private TelaPrincipal telaPrincipal;
    private AtualizarCadastro atualizarCadastro;

    public UsuarioController(CadastroUsuario telaCadastro) {
        this.telaCadastro = telaCadastro;
    }

    public UsuarioController(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }

    public UsuarioController(AtualizarCadastro atualizarCadastro) {
        this.atualizarCadastro = atualizarCadastro;
    }

    public UsuarioController() {
    }

    public void insert(Usuario user) {
        UsuarioDAO userDao = new UsuarioDAO(CriaConnDAO());
        userDao.insert(user);
    }

    public List<Usuario> buscarTodos() {
        UsuarioDAO userDao = new UsuarioDAO(CriaConnDAO());
        List<Usuario> users = userDao.findAll();
        return users;
    }

    public Usuario buscarPorId(Integer id) {
        UsuarioDAO userDao = new UsuarioDAO(CriaConnDAO());
        return userDao.findId(id);
    }

    public void deleteUser(Integer Id) {
        UsuarioDAO userDao = new UsuarioDAO(CriaConnDAO());
        userDao.deleteById(Id);
    }
    public void atualizar(Usuario user){
        UsuarioDAO userDao= new UsuarioDAO(CriaConnDAO());
        userDao.update(user);
    }
    
    
    
    private EntityManager CriaConnDAO() {
//       EntityManager em = new JPA().getEntityManager();
//       return em;
        return new JPA().getEntityManager();

    }
   

}
