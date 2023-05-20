import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    private List<User> createList(User... elems) {
        return new ArrayList<>(Arrays.asList(elems));
    }

    @Test
    void everyBranchTest(){

        List<User> allUsers = createList();
        RuntimeException ex;
        User u=new User("anastasija02@gmail.com","!@#SADSDSA","anastasija02@gmail.com");
        allUsers.add(u);
       // 1 test case
        ex= assertThrows(RuntimeException.class,() -> SILab2.function(null,allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
       // 2 test case
        User NullName = new User(null, "ani4e", "anastasija02@gmail.com");
        assertFalse(SILab2.function(NullName, allUsers));
        // 3 test case
        User uSpecialSymbols=new User("anastasija","*proba*test&","finkigmail");
        assertFalse(SILab2.function(uSpecialSymbols, allUsers));

        // 4 test case
       User UserWithNoSymbolsInPass = new User("anastasija","finkiukimmk","anastasija002@gmail.com");
        assertFalse(SILab2.function(UserWithNoSymbolsInPass,allUsers));

        //5 test case
        User UserWithSpaceInPassword = new User("ane","finki softversko","anegmail@gmail.com");
        assertFalse(SILab2.function(UserWithNoSymbolsInPass,allUsers));


    }

    @Test
    void multipleConditionTest(){


        //[T-X-X]
        User u= new User(null,null,null);
        List<User> allUsers = createList();
        RuntimeException ex;
        ex= assertThrows(RuntimeException.class,() -> SILab2.function(null,allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //[F-T-X]
        List<User> allUsers2=createList();
        User existingUser = new User("anastasija", null, "anastasija02@gmail.com");
        ex= assertThrows(RuntimeException.class,() -> SILab2.function(existingUser,allUsers2));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));


        //[F-F-T]
        User tfUser = new User("anastasija", "sacdascd12", null);
        ex= assertThrows(RuntimeException.class,() -> SILab2.function(existingUser,allUsers2));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));


    }

    @Test
    void functionalTest(){
        User validUser = new User("user", "", "ab@.@");
        List<User> allUsers = createList();

        assertFalse(SILab2.function(validUser, allUsers));

    }
}
