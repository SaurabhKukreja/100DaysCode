package misc.list;

import java.util.ArrayList;
import java.util.List;

public class ListCommonElements {

  public static void main(String[] args) {
    List<SimplePojo> list1 = new ArrayList<>();
    list1.add(new SimplePojo("Dave",49));
    list1.add(new SimplePojo("Smith",40));
    list1.add(new SimplePojo("Johnson",32));

    System.out.println("List 1: " +list1.toString());

    List<SimplePojo> list2 = new ArrayList<>();
    list2.add(new SimplePojo("Dave",49));
    list2.add(new SimplePojo("Smith",40));
    list2.add(new SimplePojo("Steve",32));

    System.out.println("List2: "+list2.toString());

    list1.retainAll(list2);

    System.out.println("Common ELements: " + list1.toString());
  }
}
