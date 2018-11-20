import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Test{
	public static void main(String[] args){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<>();
		tmp.add(0);
		tmp.add(1);
		list.add(3,tmp);
		tmp = new ArrayList<>();
		tmp.add(2);
		tmp.add(3);
		list.add(1,tmp);
		for(List<Integer> l :list){
			System.out.println(Arrays.toString(l.toArray(new Integer[0])));
		}
		tmp = list.get(1);
		List<Integer> tmp_copy = new ArrayList<>();
		for(Integer vertice: tmp)
			tmp_copy.add(vertice);
		tmp_copy.add(4);
		list.add(2,tmp_copy);
		list.set(1,tmp_copy);
		for(List<Integer> l :list){
			System.out.println(Arrays.toString(l.toArray(new Integer[0])));
		}
	}
}