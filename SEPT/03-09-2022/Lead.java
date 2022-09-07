public class Lead {
    String name;
    int id;
    
    public Lead(String name, int id) {
        this.name = name;
        this.id = id;    
    }
    
    public String toString() {
        return "name : " + name + " ID : " + id;
    }
    
    public boolean equals(Object object) {
        if(this == object)
            return true;
        if(object == null)
            return false;
        if(getClass() != object.getClass())
            return false;
        Lead newLead = (Lead)object;
        if(id != newLead.id)
            return false;   
        return true;     
    }
  
    public int hashCode() {
         final static int PRIME = 53;
         int result = 1;
         result = prime * result + id;
         result = prime * result + ((name == null) ? 0 : name.hashCode());
         return result;
     }  
}