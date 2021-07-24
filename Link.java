import java.util.Scanner;
public class Link {
    link head=null;
    link tail=null;
    link mid=null;
    int size=0;
    class link{
        int data=0;
        link next=null;
        link pre=null;
        public link(int dd){
            this.data=dd;
        }
    }
    public void printlists(){
        mid=head;
        System.out.println("正序输出");
        for(int i=0;i<size;i++){
            System.out.print(mid.data+" ");
            mid=mid.next;
        }
        System.out.println("");
    }
    public void printlistf(){
        mid=tail;
        System.out.println("逆序输出");
        for(int i=0;i<size;i++){
            System.out.print(mid.data+" ");
            mid=mid.pre;
        }
        System.out.println("");
    }
    public void addnode(int data){
        link newnode=new link(data);
        if(size==0){
            head=new link(data);
            tail=head;
            size++;
        }else{
            mid=new link(data);
            mid.pre=tail;
            tail.next=mid;
            tail=mid;
            size++;
        }
        tail.next=head;
        head.pre=tail;
    }
    public void removenode(int index){
        if(index>size||size==0){
            System.out.println("节点不存在");
            return;
        }
        if(index==0){
            mid=head.next;
            mid.pre=null;
            head.next=null;
            size--;
        }
        else if(index==size-1){
            tail=tail.pre;
            tail.next=head;
            head.pre=tail;
            size--;
        }
        else{
            mid=head;
            for(int i=0;i<index;i++){
                mid=mid.next;
            }
            mid.pre.next=mid.next;
            mid.next.pre=mid.pre;
            size--;
        }
        tail.next=head;
        head.pre=tail;
    }
    public void findnode(int data){
        int index=0;
        int flag=1;
        mid=head;
        while(index<size){
            if(mid.data==data){
                System.out.println(data+"位于第"+index+"节点");
                flag=0;
            }
            mid=mid.next;
            index++;
        }
        if(flag==1){
            System.out.println("未找到相应点");
        }
    }
    public void changenode(int index,int data){
        if(index>size||size==0){
            System.out.println("节点不存在");
            return;
        }
        if(index==0){
            head.data=data;
        }
        else{
            mid=head;
            for(int i=0;i<index;i++){
                mid=mid.next;
            }
            mid.data=data;
        }
    }
    public void insertnode(int index,int data){
        if(index>size||size==0){
            System.out.println("节点不存在");
            return;
        }
        if(index==0){
            mid=new link(data);
            head.pre=mid;
            mid.next=head;
            head=mid;
            size++;
        }
        else if(index==size){
            addnode(data);
        }
        else{
            mid=new link(data);
            link temp=head;
            for(int i=0;i<index;i++){
                temp=temp.next;
            }
            mid.next=temp;
            mid.pre=temp.pre;
            temp.pre.next=mid;
            temp.pre=mid;
            size++;
        }
        tail.next=head;
        head.pre=tail;
    }
    public static void main(String[] args) {
        Link list=new Link();
        Scanner sc=new Scanner(System.in);
        int data;
        int index;
        int op=0;
        while(op!=6){
            System.out.println("输入数字：1.增加1个链表节点；2.删除一个链表节点；3.按数据查找节点；4.改变节点数据；5.插入节点；6.退出");
            op=sc.nextInt();
            switch(op){
                case 1:
                    System.out.println("输入添加的数据");
                    data=sc.nextInt();
                    list.addnode(data);
                    break;
                case 2:
                    System.out.println("输入删除的节点");
                    data=sc.nextInt();
                    list.removenode(data);
                    break;
                case 3:
                    System.out.println("输入查询的数据");
                    data=sc.nextInt();
                    list.findnode(data);
                    break;
                case 4:
                    System.out.println("输入需要改变的节点");
                    index=sc.nextInt();
                    System.out.println("输入改变的数据");
                    data=sc.nextInt();
                    list.changenode(index,data);
                    break;
                case 5:
                    System.out.println("输入需要插入的节点");
                    index=sc.nextInt();
                    System.out.println("输入添加的数据");
                    data=sc.nextInt();
                    list.insertnode(index,data);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("请输入正确的数字！");
            }
            list.printlists();
            list.printlistf();
        }
    }
}
