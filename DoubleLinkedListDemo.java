public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试");
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");
        HeroNode hero5 = new HeroNode(5,"武松","行者");
        DoubleLinkedList dLL = new DoubleLinkedList();
        dLL.add(hero1);
        dLL.add(hero2);
        dLL.add(hero3);
        dLL.add(hero4);
        dLL.add(hero5);
        dLL.list();
        System.out.println("删除");
        dLL.del(hero5);
        dLL.list();
        System.out.println("获取头");
        dLL.getHead();
        System.out.println("修改");

        dLL.updata(new HeroNode(4,"鲁智深","花和尚"));
        dLL.list();



    }

   static class DoubleLinkedList {
        //        头节点
        private HeroNode head = new HeroNode(0, "", "");

        //        返回头节点
        public HeroNode getHead() {
            System.out.println(head);
            return head;
        }

        //        遍历节点
        public void list() {
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            HeroNode temp = head;
            while (true) {
                if (temp.next == null) {
                    System.out.println("已到末尾");
                    break;
                }
                temp = temp.next;
                System.out.println(temp);
            }
        }

        //        添加节点
        public void add(HeroNode heroNode) {
            HeroNode temp = head;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            temp.next = heroNode;
            heroNode.pre = temp;
        }

        //            修改节点
        public void updata(HeroNode newheroNode) {
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            HeroNode temp = head;
            boolean flag = false;
            while (true) {

                if (temp.no == newheroNode.no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                temp.name = newheroNode.name;
                temp.nickname = newheroNode.nickname;
            } else {
                System.out.println("没有找到");
            }

        }

        //        删除
        public void del(HeroNode heroNode) {
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            HeroNode temp = head;
            boolean flag = false;
            while (true) {
                if (temp == null) {
                    break;
                }
                if (temp.no == heroNode.no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                temp.pre.next = temp.next;
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
            } else {
                System.out.println("没有找到");
            }

        }

    }

    static class  HeroNode {
        public int no;
        public String name;
        public String nickname;
        public HeroNode next;
        public HeroNode pre;

        public HeroNode(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }
}

