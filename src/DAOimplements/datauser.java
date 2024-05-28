/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOimplements;
import java.util.List;
import model.user;

/**
 *
 * @author abaym
 */
public interface datauser {
    public void select(user u);
    public void insert(user u);
    public void update(user u);
    public void delete(user u);
    public List<user>getAll();
}
