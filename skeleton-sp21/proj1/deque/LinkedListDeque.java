package deque;

public class LinkedListDeque <ParaTBD> {

    private StuffNode sentinel;
    private int size = 0 ;

    public class StuffNode{
        public StuffNode pre;
        public ParaTBD item;
        public StuffNode next;

        public StuffNode(StuffNode p, ParaTBD x, StuffNode n ){
            pre = p;
            item = x;
            next = n;
        }
    }

    public int size(){
        return size;
    }

    public LinkedListDeque(){
        sentinel = new StuffNode(null, (ParaTBD) "666",null);
    }


    public void addFirst(ParaTBD x){
        if(size == 0){
            sentinel.next = new StuffNode(sentinel,x,sentinel);
            sentinel.pre = sentinel.next;
        }
        else{
            StuffNode p = new StuffNode(null,x,null);
            p.pre = sentinel;
            p.next = sentinel.next;
            sentinel.next.pre = p;
            sentinel.next = p;
        }
        size +=1;
    }

    public static void main(String[] args){
        LinkedListDeque<String> L = new LinkedListDeque<>();
        L.addFirst("5");
        L.addFirst("4");
        L.addFirst("3");
        L.addFirst("2");
        L.addFirst("1");
        L.addFirst("0");
        L.addFirst("-1");
        L.addFirst("hahah");
        System.out.println(L.size());
    }


}
