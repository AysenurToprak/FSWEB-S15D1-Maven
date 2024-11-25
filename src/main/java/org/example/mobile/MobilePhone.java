package org.example.mobile;

import java.util.List;

public class MobilePhone {
    String myNumber ;
    List<Contact> myContacts ;
    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }
  public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
  }

  public int findContact(String name) {
        for ( int i = 0 ; i<myContacts.size();i++) {
            Contact contact = myContacts.get(i);
            if(contact.getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
  }
    public boolean addNewContact (Contact contact) {
        if (contact == null || contact.getName() == null || contact.getPhoneNumber() == null) {
            return false;
        }
        if (findContact(contact.getName()) >= 0) {
            return false;
        }
        return this.myContacts.add(contact);
    }
  public boolean updateContact(Contact oldContact, Contact newContact) {
        int index = findContact(oldContact);
      if(index <= 0) {
          return false;
      }
      this.myContacts.set(index, newContact);
      return true;
  }
  public boolean removeContact(Contact contact) {
    if (contact == null || findContact(contact) < 0) {
        return false;
    }
      return this.myContacts.remove(contact);

  }
  public Contact queryContact(String name) {
        int index = findContact(name);
        if(index <= 0) {
            return null;
        }
      return this.myContacts.get(index);
  }
  public void printContact(){
for(int i = 0;i<myContacts.size();i++) {
    Contact contact = myContacts.get(i);
    System.out.println(contact.getName() + " " + contact.getPhoneNumber());
}
  }

}
