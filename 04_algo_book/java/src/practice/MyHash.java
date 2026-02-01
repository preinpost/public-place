package practice;

public class MyHash {
    public Slot[] hastTable;

    public MyHash(Integer size) {
        this.hastTable = new Slot[size];
    }

    public class Slot {
        String key;
        String value;
        Slot next;

        Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public Integer hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hastTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hastTable[address] != null) {
            Slot findSlot = this.hastTable[address];
            Slot prevSlot = this.hastTable[address];

            while(findSlot != null) {
                if (findSlot.key == key) {
                    findSlot.value = value;
                    return true;
                } else {
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            prevSlot.next = new Slot(key, value);

        } else {
            this.hastTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hastTable[address] != null) {
            Slot findSlot = this.hastTable[address];
            while (findSlot != null) {
                if (findSlot.key == key) {
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        MyHash myHash = new MyHash(20);

        myHash.saveData("DaveLee", "11111");
        myHash.saveData("fun-coding", "22222");
        myHash.saveData("David", "33333");
        myHash.saveData("Dave", "44444");
        String daveLee = myHash.getData("David");
        System.out.println("DaveLee = " + daveLee);
    }
}
