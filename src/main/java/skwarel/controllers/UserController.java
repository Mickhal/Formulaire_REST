package skwarel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skwarel.models.users.User;
import skwarel.services.UserServiceImpl;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by mickael on 07/06/16.
 */
@RestController
@RequestMapping("/userCtrl")
public class UserController {
    private static final AtomicLong counter = new AtomicLong();
    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value="/addUser", method=RequestMethod.POST)
    public void addUser(@RequestBody LinkedHashMap<String,String> usr) {
        User user = new User(usr.get("nom"),usr.get("prenom"),usr.get("genre"),usr.get("dateNaissance"),usr.get("mail"),counter.incrementAndGet());
        userService.addUser(user);
        /*HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        headers.set("Id", String.valueOf(user.getId()));*/

        //return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        //return "'id':'"+String.valueOf(user.getId())+"'";

    }

    @RequestMapping(value="/getListUsers", method=RequestMethod.GET)
    public ResponseEntity<HashMap> getListUsers() {
        HashMap resultat = userService.getListUsers();
        return new ResponseEntity<HashMap>(resultat, HttpStatus.OK);
    }

    @RequestMapping(value="/getOneUser/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getOneUser(@PathVariable long id) {
        User u = userService.getOneUser(id);
        return new ResponseEntity<User>(u, HttpStatus.OK);


    }

    @RequestMapping(value="/deleteUsers", method=RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUsers() {
        userService.removeAll();
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers,HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/deleteUser/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable long id) {
            userService.removeOne(id);
        }


    @RequestMapping(value="/updateUser/{id}/newInfo/{newMail}", method = RequestMethod.POST) /*un put est un post qui s'ignore laul*/
    public void updateUser(@PathVariable long id, @PathVariable String newMail) {
        userService.updateUser(id, newMail);
    }

}
