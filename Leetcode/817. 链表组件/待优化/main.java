public class main {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {

        int[] h = {0, 1, 2, 3};
        int[] g = {0, 1, 3};
        int[] k = {3, 1, 0};
        ListNode hlist = ints2ListNode(h);
        ListNode glist = ints2ListNode(g);
        ListNode klist = ints2ListNode(k);
        klist = SortListNode(hlist, klist);

//        System.out.println("hlist");
//        while(hlist!=null)
//        {
//            System.out.println(hlist.val);
//            hlist=hlist.next;
//        }
//        System.out.println("glist");
//        while(glist!=null)
//        {
//            System.out.println(glist.val);
//            glist=glist.next;
//        }
        System.out.println("klist");
//        while (klist != null) {
//            System.out.println(klist.val);
//            klist = klist.next;
//        }
        System.out.println("klist");

        int numc = numC(hlist, klist);
        System.out.println("numc:"+numc);


    }

    public static ListNode ints2ListNode(int[] a) {
        if (a.length == 0) {

            return null;
        } else {
            ListNode res = new ListNode(a[0]);
            ListNode root = res;
            if (a.length > 1) {
                for (int i = 1; i < a.length; ++i) {
                    ListNode res_next = new ListNode(0);
                    res_next.val = a[i];
                    res.next = res_next;
                    res = res.next;
                }
            }
            return root;
        }
    }

    public static ListNode SortListNode(ListNode lon, ListNode shor) {
        //h
        boolean del_bool=true;
        ListNode shor_copy=shor;
        ListNode lon_copy=lon;
        int num_shor=0;
        int index=0;

        while(shor_copy!=null)
        {
            num_shor++;
            shor_copy=shor_copy.next;
        }
        shor_copy=shor;
        int[] sort=new int[num_shor];
        while(lon_copy!=null)
        {
            while (shor_copy!=null)
            {
                if(shor_copy.val==lon_copy.val)
                {
                    sort[index]=shor_copy.val;
                    index++;
                }
                shor_copy=shor_copy.next;
            }
            shor_copy=shor;
            lon_copy=lon_copy.next;
        }
        lon_copy=lon;


        ListNode return_node=ints2ListNode(sort);


        return return_node;

    }



    public static int numC(ListNode h, ListNode g) {
        int res = 0;
        boolean resIncrease = false;
        while (h != null) {

            while (g != null && h != null && g.val == h.val) {

                //System.out.println(h.val);

                g = g.next;
                h = h.next;
                resIncrease = true;
            }
            if (resIncrease) {
                res++;
                resIncrease = false;
            }
            if (h != null) {
                h = h.next;
            }
        }
        return res;
    }


}
