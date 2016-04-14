package Office;

//import java.util.*;

import com.google.common.collect.Lists;

import java.util.*;

public class OfficeMain {

    static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }



    public static void main(String[] args) {

//        Printer superPrinter = new Printer();
//        Employee karl = new Clerk(superPrinter);
//
//        karl.printDocument("kake");
        ArrayList ninja = Lists.newArrayList(1, 2, 3);
        System.out.println(ninja);

        Map<String, List<Integer>> kake = new HashMap<>();

//        kake.put("kaffe", new ArrayList<>());
        List<Integer> bolle = Lists.newArrayList(1, 2, 3, 4);





        System.out.println(bolle.add(5) ? bolle:null);
        kake.put("kaffe", new ArrayList<>());
//        System.out.println(kake.getOrDefault("kaffe", new ArrayList<>()).add(3) ? kake.get("kaffe"):"ninja");

//        if (kake.get("kaffe").add(3)) {
//            System.out.println(kake.get("kaffe"));
//        }



//        Printer ikkeSåSuperPrinter = new Printer();
//        Employee bob = new Clerk(ikkeSåSuperPrinter);
//        Employee karl = new Clerk(ikkeSåSuperPrinter);
//        Employee kevin = new Clerk(ikkeSåSuperPrinter);
//        Employee john = new Manager(Arrays.asList(new Clerk(superPrinter)));
//        Employee stuart = new Manager(Arrays.asList(bob, karl, kevin, john));
//        System.out.println(stuart.getResourceCount());

    }




}
