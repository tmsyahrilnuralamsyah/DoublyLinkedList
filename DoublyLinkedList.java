public class DoublyLinkedList<Tipe> {
    protected NodeDoubly<Tipe> first;
    protected NodeDoubly<Tipe> last;
    public int size;
    
    // Constructor
    public DoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }
    
    // Method untuk mengecek apakah linked list kosong
    public boolean isEmpty() {
        return first == null;
    }
    
    // Method untuk mengembalikan ukuran linked list
    public int getSize() {
        return size;
    }
    
    // Method untuk menambah elemen di awal linked list
    public void insertAwal(Tipe val) {
        NodeDoubly<Tipe> nptr = new NodeDoubly<Tipe>(val, null, null);
        if (first == null) {
            first = nptr;
            last = first;
        } else {
            first.setLinkPrev(nptr);
            nptr.setLinkNext(first);
            first = nptr;         
        }
        size++;
    }
    
    // Method untuk menambah elemen di akhir linked list
    public void insertAkhir(Tipe val) {
        NodeDoubly<Tipe> nptr = new NodeDoubly<Tipe>(val, null, null);
        if (first == null) {
            first = nptr;
            last = first;
        } else {
            nptr.setLinkPrev(last);
            last.setLinkNext(nptr);
            last = nptr;
        }
        size++;
    }
    
    // Method untuk menambah elemen di sekitar tengah
    public void insertAtPos(Tipe val , int pos) {
        NodeDoubly<Tipe> nptr = new NodeDoubly<Tipe>(val, null, null);
        if (pos > size)
            System.out.println("Posisi melebihi batas linked list");         
        else if (pos == 1)
            insertAwal(val);         
        else if (pos == size)
            insertAkhir(val);
        else {
            NodeDoubly<Tipe> ptr = first;
            for (int i = 2; i <= size; i++) {
                if (i == pos) {
                    NodeDoubly<Tipe> tmp = ptr.getLinkNext();
                    ptr.setLinkNext(nptr);
                    nptr.setLinkPrev(ptr);
                    nptr.setLinkNext(tmp);
                    tmp.setLinkPrev(nptr);
                }
                ptr = ptr.getLinkNext();
            }
            size++ ;
        }
    }
    
    // Method untuk menghapus node di awal linked list
    public void deleteAwal() {
        if (size == 1) {
            first = null;
            last = null;
            size = 0;
        } else {
            first = first.getLinkNext();
            first.setLinkPrev(null);
            size--;
        }
    }
    
    // Method untuk menghapus node di akhir linked list
    public void deleteAkhir() {
        last = last.getLinkPrev();
        last.setLinkNext(null);
        size--;
    }
    
    // Method untuk menghapus node di posisi tertentu
    public void deleteAtPos(int pos) {
        if (pos > size)
            System.out.println("Posisi node melebihi ukuran");
        else if (pos == 1)
            this.deleteAwal();
        else if (pos == size)
            this.deleteAkhir();
        else {
            NodeDoubly<Tipe> ptr = first.getLinkNext();
            for (int i = 2; i <= size; i++) {
                if (i == pos) {
                    NodeDoubly<Tipe> p = ptr.getLinkPrev();
                    NodeDoubly<Tipe> n = ptr.getLinkNext();
                    p.setLinkNext(n);
                    n.setLinkPrev(p);
                    size--;
                }
                ptr = ptr.getLinkNext();
            }
        }
    }
    
    // Method untuk menampilkan semua unsur dalam linked list
    public void display() {
        NodeDoubly<Tipe> ptr = first;
        while (true) {
            if (ptr == null)
                break;
            System.out.print(ptr.getData() + " -> ");
            ptr = ptr.getLinkNext();
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        DoublyLinkedList<String> dl = new DoublyLinkedList<>();
        dl.insertAwal("a");
        dl.insertAwal("b");
        dl.insertAkhir("c");
        dl.insertAtPos("d", 2);
        dl.insertAtPos("e", 1);
        dl.display();
        dl.deleteAwal();
        dl.deleteAkhir();
        dl.deleteAtPos(2);
        dl.display();
    }
}