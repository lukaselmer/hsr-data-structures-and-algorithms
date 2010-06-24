package u4a5;

public class Permutationen<T> {

    public void permutationen(Queue<T> q, Stack<T> s) {
        if (q.isEmpty()) {
            System.out.print("Permutation : ");
            s.print();
            System.out.println();
        }
        for (int i = 0; i < q.size(); i++) {
            s.push(q.dequeue());
            permutationen(q, s);
            q.enqueue(s.pop());
        }
    }

    public static void main(String[] args) {
        Permutationen<String> perm = new Permutationen<String>();
        QueueImpl<String> q = new QueueImpl<String>(String.class);
        q.tracing(false);
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        q.enqueue("d");
        StackImpl<String> s = new StackImpl<String>();
        perm.permutationen(q, s);
    }
}

/* Session-Log (SOLL):

Permutation : abcd
Permutation : abdc
Permutation : acdb
Permutation : acbd
Permutation : adbc
Permutation : adcb
Permutation : bcda
Permutation : bcad
Permutation : bdac
Permutation : bdca
Permutation : bacd
Permutation : badc
Permutation : cdab
Permutation : cdba
Permutation : cabd
Permutation : cadb
Permutation : cbda
Permutation : cbad
Permutation : dabc
Permutation : dacb
Permutation : dbca
Permutation : dbac
Permutation : dcab
Permutation : dcba

 */
