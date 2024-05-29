/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOimplements;
import java.util.List;
import model.parkir;
/**
 *
 * @author abaym
 */
public interface dataparkir {
    public void insert(parkir p);
    public void update(parkir p);
    public void delete(parkir p);
    public List<parkir>getAll();
    public List<parkir>getAll2();
}
