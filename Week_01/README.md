学习笔记
	经过一段时间的思考，还是觉得报一个训练营的课程，以此来督促自己的学习，也是想在算法上有个明显的提升。
	第一周我低估了课程的容量，再加上刚到新项目组，一直在加班适应，所以课程的进度很不理想，
花了两个晚上把课程都听完了，但也只是听完，没有复习的过程，习题也还没来得及练习，在周末的时间里无论如何把作业完成。
	老师介绍的四步切题法和五遍刷题法，都很有针对性，正确的方法加反复练习，是学习一项技能的不二法门。
下一周里一定要规划好时间和学习的节奏，争取达到理想的学习效果。

public class DequeDemo {

    public static void main(String[] args) {
        origin();
        System.out.println("--------------");
        modify();
    }

    /**
     * 改写前
     */
    private static void origin() {
        Deque<String> deque = new LinkedList<String>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size() > 0) {
            System.out.println(deque.pop());
        }

        System.out.println(deque);
    }

    /**
     * 改写后
     */
    private static void modify() {
        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.getFirst();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }
}