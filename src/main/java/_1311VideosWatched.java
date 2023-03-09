import java.util.*;

public class _1311VideosWatched {

    class VideoFrequency implements Comparable<VideoFrequency>{
        int count;
        String video;

        public VideoFrequency(int count,String video){
            this.count = count;
            this.video = video;
        }

        @Override
        public int compareTo(VideoFrequency videoFrequency) {

            if(this.count==videoFrequency.count) return this.video.compareTo(videoFrequency.video);
            return this.count-videoFrequency.count;
        }
    }

    public List<String> watchedVideosByFriends(
            List<List<String>> watchedVideos, int[][] friends, int id, int level
    ) {

        Queue<Integer>queue = new LinkedList<>();
        boolean visited[] = new boolean[friends.length];
        queue.add(id);

        int l = 0;
        while(!queue.isEmpty()){

            int size = queue.size();
            while (size!=0){
                int root = queue.poll();
                visited[root] = true;
                int children[] = friends[root];

                for(int i=0;i<children.length;i++){
                    if(!visited[children[i]]){
                        queue.add(children[i]);
                    }
                }
                --size;
            }

            l++;
            if(l==level){
                break;
            }
        }

        HashMap<String,Integer>map = new HashMap<>();
        while(!queue.isEmpty()){
            int child = queue.poll();
            List<String> cWatchedVideos = watchedVideos.get(child);
            for(int j=0;j<cWatchedVideos.size();j++){
                String watchedVideo = cWatchedVideos.get(j);
                if(map.containsKey(watchedVideo)){
                    map.put(watchedVideo,map.get(watchedVideo)+1);
                } else{
                    map.put(watchedVideo,1);
                }
            }
        }

        Iterator<Map.Entry<String,Integer>>ite = map.entrySet().iterator();
        List<VideoFrequency>list = new LinkedList<>();
        while(ite.hasNext()){
            Map.Entry<String,Integer>entry = ite.next();
            list.add(new VideoFrequency(entry.getValue(),entry.getKey()));
        }
        Collections.sort(list);

        List<String> result = new LinkedList<>();
        for(VideoFrequency videoFrequency:list){
            result.add(videoFrequency.video);
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<String>>watchedVideos = new LinkedList<>();

        List<String>watchedVideo = new LinkedList<>();
        watchedVideo.add("A");
        watchedVideo.add("B");
        watchedVideos.add(watchedVideo);

        watchedVideo = new LinkedList<>();
        watchedVideo.add("C");
        watchedVideos.add(watchedVideo);

        watchedVideo = new LinkedList<>();
        watchedVideo.add("B");
        watchedVideo.add("C");
        watchedVideos.add(watchedVideo);

        watchedVideo = new LinkedList<>();
        watchedVideo.add("D");
        watchedVideos.add(watchedVideo);

        int friends[][] = new int[][]{{1,2},{0,3},{0,3},{1,2}};
        int id = 0;
        int level = 2;
        _1311VideosWatched obj = new _1311VideosWatched();
        System.out.println(obj.watchedVideosByFriends(watchedVideos,friends,id,level));
    }
}
