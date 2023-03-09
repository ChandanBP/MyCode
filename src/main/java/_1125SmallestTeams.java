import java.util.*;

public class _1125SmallestTeams {

	int RQ[];
	long PM[];
	int PS[];
	int P;
	int R;
	HashMap<String, Integer> map = new HashMap<>();
	HashMap<Integer, Long> map1 = new HashMap<Integer, Long>();

	public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

		if (req_skills == null || req_skills.length == 0) return new int[]{};

		// Mapping required skills to subset number
		RQ = new int[req_skills.length];
		int power = 1;
		for (int i = 0; i < req_skills.length; i++) {
			RQ[i] = power;
			power <<= 1;
		}

		for (int i = 0; i < req_skills.length; i++) {
			map.put(req_skills[i], RQ[i]);
		}

		long p1 = 1;
		PM = new long[people.size()];
		for (int i = 0; i < PM.length; i++) {
			PM[i] = p1;
			p1 <<= 1;
		}

		for (int i = 0; i < people.size(); i++) {
			map1.put(i, PM[i]);
		}

		// Map people skills to subset number
		ListIterator<List<String>> iterator = people.listIterator();
		PS = new int[people.size()];
		int i = 0;

		while (iterator.hasNext()) {
			List<String> skills = iterator.next();
			ListIterator<String> sk = skills.listIterator();
			int l = 0;
			while (sk.hasNext()) {
				String s = sk.next();
				l |= (map.containsKey(s))?map.get(s):0;
			}
			PS[i++] = l;
		}

		P = PS.length;
		R = (1 << req_skills.length);
		long dp[][] = new long[P][R];

		for (int p = 0; p < P; p++){
			for (int r = 1; r < R; r++){
				Arrays.fill(dp[p],Long.MAX_VALUE);
			}
		}

		for (int p = 0; p < P; p++) {

			int personSkills = PS[p];
			for (int r = 1; r < R; r++) {

				int reqSkills = r;
				int res = personSkills & reqSkills;
				long personMapping = map1.get(p);

				if (res == reqSkills) {
					dp[p][r] = personMapping;
				} else {

					int remSkills = 0;
					int mask = 1;
					int c = 0;
					while (c < 32) {
						++c;
						if (((mask & reqSkills) > 0) && ((mask & res) == 0)) {
							remSkills |= mask;
						}
						mask <<= 1;
					}

					if(p==0){
						dp[p][r]=Long.MAX_VALUE;
					}else{

						int resources = getResourcesCovered(dp[p - 1][remSkills]);
						if((resources&r)==r){
							dp[p][r] = dp[p-1][remSkills];
							continue;
						}

						int count1 = getOnes(dp[p - 1][r]);
						int count2 = getOnes(dp[p - 1][remSkills] | personMapping);

						dp[p][r] = (count1<=count2)?dp[p - 1][r] : dp[p - 1][remSkills] | personMapping;
					}
				}
			}
		}

		long res = dp[P - 1][R - 1];
		long mask = 1;
		int c = 0;
		LinkedList<Integer> r = new LinkedList();

		while (c < people.size()) {
			if ((mask & res) > 0) {
				r.add(c);
			}
			mask <<= 1;
			++c;
		}

		ListIterator<Integer> ite = r.listIterator();
		int value[] = new int[r.size()];
		int k = 0;

		while (ite.hasNext()) {
			value[k++] = ite.next();
		}
		return value;
	}

	public int getResourcesCovered(long people){

		if(people==Long.MAX_VALUE)return 0;
		int mask = 1;
		int c=0;
		int resources=0;
		while(c<64){
			if((mask&people)>0){
				resources|=PS[c];
			}
			++c;
			mask<<=1;
		}
		return resources;
	}

	public int getOnes(long x) {
		int c = 0;
		int mask = 1;
		int count = 0;
		while (c < 64) {
			if ((mask & x) > 0) {
				++count;
			}
			++c;
			mask<<=1;
		}
		return count;
	}

    public static void main(String[] args) {

        String req_skills[] = {"hkyodbbhr","p","biflxurxdvb","x","qq","yhiwcn"};
        List<List<String>> people = new LinkedList();
        people.add(Arrays.asList("yhiwcn"));
		people.add(Arrays.asList(""));
		people.add(Arrays.asList(""));
		people.add(Arrays.asList(""));
        people.add(Arrays.asList("biflxurxdvb","yhiwcn"));
        people.add(Arrays.asList("hkyodbbhr"));
        people.add(Arrays.asList("hkyodbbhr","p"));
		people.add(Arrays.asList("hkyodbbhr"));
        _1125SmallestTeams obj = new _1125SmallestTeams();
        System.out.println(obj.smallestSufficientTeam(req_skills, people).toString());

    }
}