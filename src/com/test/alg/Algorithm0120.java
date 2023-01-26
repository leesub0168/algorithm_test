package com.test.alg;

import java.io.*;
import java.util.*;

class Test0120 {
    public void painting_1926(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        int[][] arr = new int[502][502];
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] vis = new boolean[502][502];

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int mx = 0;
        int num = 0;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(arr[i][j] == 0 || vis[i][j]) continue;
                num++;

                ArrayDeque<AbstractMap.SimpleEntry<Integer,Integer>> deque = new ArrayDeque<>();
                vis[i][j] = true;
                deque.push(new AbstractMap.SimpleEntry<>(i,j));
                int area = 0;
                while (!deque.isEmpty()) {
                    area++;
                    AbstractMap.SimpleEntry<Integer,Integer> s = deque.getFirst();
                    deque.pop();

                    for(int dir=0;dir<4;dir++) {
                        int nx = s.getKey() + dx[dir];
                        int ny = s.getValue() + dy[dir];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if(vis[nx][ny] || arr[nx][ny] != 1) continue;
                        vis[nx][ny] = true;
                        deque.push(new AbstractMap.SimpleEntry<>(nx,ny));
                    }
                }

                if(mx < area) mx = area;
            }
        }

        bw.write(num + "\n");
        bw.write(mx + "\n");
        bw.flush();
        bw.close();
    }

    public void maze_search_2178(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        int[][] board = new int[n+1][m+1];
        boolean[][] vis = new boolean[n+1][m+1];

        for(int i=0;i<n;i++) {
            String s = br.readLine();
            for(int j=0;j<m;j++) {
                board[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        Queue<EntryPair> deque = new LinkedList<>();
        deque.add(new EntryPair(0,0));
        vis[0][0] = true;

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        while (!deque.isEmpty()) {
            EntryPair pair = deque.remove();
            for(int dir=0;dir<4;dir++) {
                int xx = pair.x + dx[dir];
                int yy = pair.y + dy[dir];

                if(xx >= 0 && yy >= 0 && xx < m && yy < n) {
                    if(board[yy][xx] != 0 && !vis[yy][xx]) {
                        vis[yy][xx] = true;
                        board[yy][xx] = board[pair.y][pair.x] + 1;
                        deque.add(new EntryPair(xx,yy));
                    }
                }
            }
        }

        bw.write(board[n-1][m-1]+"");
        bw.flush();
        bw.close();
    }

    public void tomato_7576(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] box = new int[n+1][m+1];
        boolean[][] vis = new boolean[n+1][m+1];

        for(int i=0;i<n;i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                box[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        Queue<EntryPair> queue = new ArrayDeque<>();
        queue.add(new EntryPair(0,0));
        vis[0][0] = true;

        while (!queue.isEmpty()) {
            EntryPair pair = queue.remove();
//            if(box[pair.x][pair.y] < 0) {
//                vis[pair.x][pair.y] = true;
//                continue;
//            }
            for (int i=0;i<4;i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(!vis[nx][ny] && box[nx][ny] >= 0) {
                        box[nx][ny] = box[pair.x][pair.y] + 1;
                        vis[nx][ny] = true;
                        queue.add(new EntryPair(nx,ny));
                    }
                }
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                bw.write(box[i][j]+" ");
            }
            bw.write("\n");
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                bw.write(vis[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }

    public void tomato_7576_answer(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] box = new int[1002][1002];
        int[][] dist = new int[1002][1002];
        Queue<EntryPair> queue = new ArrayDeque<>();

        for(int i=0;i<n;i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                box[i][j] = Integer.parseInt(st1.nextToken());
                if(box[i][j] == 1) {
                    queue.add(new EntryPair(i,j));
                }
                if(box[i][j] == 0) {
                    dist[i][j] = -1;
                }
            }
        }
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        while (!queue.isEmpty()) {
            EntryPair pair = queue.remove();
            for (int i=0;i<4;i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(dist[nx][ny] >= 0) continue;
                dist[nx][ny] = dist[pair.x][pair.y] + 1;
                queue.add(new EntryPair(nx,ny));
            }
        }
        int ans = Integer.MIN_VALUE;
        boolean flag = false;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(!flag && dist[i][j] == -1) {
                    // 2 2
                    // 0 0
                    // 0 0 인 경우, -1이 여러번 출력되면서 오답처리됨. -1이 한번만 출력되도록 수정
                    bw.write("-1");
                    flag = true;
                }
                ans = Math.max(ans, dist[i][j]);
            }
        }
        if(!flag) {
            bw.write(ans+"");
        }
        bw.flush();
        bw.close();
    }

    public void maze_fire_4179(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] dist1 = new int[1002][1002];
        int[][] dist2 = new int[1002][1002];
        char[][] maze = new char[1002][1002];

        Queue<EntryPair> queue1 = new ArrayDeque<>();
        Queue<EntryPair> queue2 = new ArrayDeque<>();

        for(int i=0;i<r;i++) {
            String s = br.readLine();
            for(int j=0;j<c;j++) {
                maze[i][j] = s.charAt(j);
                dist1[i][j] = -1;
                dist2[i][j] = -1;

                if(maze[i][j] == 'J') {
                    queue1.add(new EntryPair(i,j));
                    dist1[i][j] = 0;
                }
                if(maze[i][j] == 'F') {
                    queue2.add(new EntryPair(i,j));
                    dist2[i][j] = 0;
                }
            }
        }

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        while(!queue2.isEmpty()) {
            EntryPair pair = queue2.remove();
            for(int dir=0;dir<4;dir++) {
                int nx = pair.x + dx[dir];
                int ny = pair.y + dy[dir];

                if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if(dist2[nx][ny] >= 0 || maze[nx][ny] == '#') continue;
                dist2[nx][ny] = dist2[pair.x][pair.y] + 1;
                queue2.add(new EntryPair(nx,ny));

            }
        }
        while(!queue1.isEmpty()) {
            EntryPair pair = queue1.remove();
            for(int dir=0;dir<4;dir++) {
                int nx = pair.x + dx[dir];
                int ny = pair.y + dy[dir];

                if(nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    bw.write((dist1[pair.x][pair.y] +1)+"");
                    bw.flush();
                    bw.close();
                    return;
                };
                if(dist1[nx][ny] >= 0 || maze[nx][ny] == '#') continue;
                if(dist2[nx][ny] != -1 &&  dist2[nx][ny] <= dist1[pair.x][pair.y] + 1) continue;
                dist1[nx][ny] = dist1[pair.x][pair.y] + 1;
                queue1.add(new EntryPair(nx,ny));
            }
        }
        bw.write("IMPOSSIBLE");
        bw.flush();
        bw.close();
    }

    public void hide_1697(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[100002];
        Arrays.fill(arr, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n);

        arr[n] = 0;

        while(!queue.isEmpty()) {
            int x = queue.remove();

            int[] move = {x-1,x+1,x*2};
            for(int i=0;i<3;i++) {
                int nx = move[i];

                if(nx < 0 || nx >= arr.length) continue;
                if(arr[nx] != -1) continue;
                arr[nx] = arr[x] + 1;
                queue.add(nx);
            }
        }
        bw.write("\n");
        bw.write(arr[k]+"");
        bw.flush();
        bw.close();
    }

    public void cabbage_1012(BufferedReader br, BufferedWriter bw) throws IOException {
        int cnt = Integer.parseInt(br.readLine());
        for(int i=0;i<cnt;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int cab = Integer.parseInt(st.nextToken());
            int[][] field = new int[52][52];
            boolean[][] vis = new boolean[52][52];


            for(int j=0;j<cab;j++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                int nx = Integer.parseInt(st1.nextToken());
                int ny = Integer.parseInt(st1.nextToken());
                field[nx][ny] = 1;
            }

            int[] dx = {1,0,-1,0};
            int[] dy = {0,1,0,-1};
            int num = 0;

            for(int j=0;j<m;j++) {
                for(int k=0;k<n;k++) {
                    if(field[j][k] == 0 || vis[j][k]) continue;
                    num++;

                    Queue<EntryPair> queue = new ArrayDeque<>();
                    vis[j][k] = true;
                    queue.add(new EntryPair(j,k));
                    while (!queue.isEmpty()) {
                        EntryPair pair = queue.remove();
                        for(int dir=0;dir<4;dir++) {
                            int nx = pair.x + dx[dir];
                            int ny = pair.y + dy[dir];
                            if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                            if(vis[nx][ny] || field[nx][ny] != 1) continue;
                            vis[nx][ny] = true;
                            queue.add(new EntryPair(nx,ny));
                        }
                    }
                }
            }
            bw.write(num + "\n");
        }
        bw.flush();
        bw.close();
    }

    public void color_blindness_10026(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[102][102];
        char[][] color_arr = new char[102][102];
        boolean[][] vis1 = new boolean[102][102];
        boolean[][] vis2 = new boolean[102][102];


        for(int i=0;i<n;i++) {
            String s = br.readLine();
            for(int j=0;j<n;j++) {
                arr[i][j] = s.charAt(j);
                color_arr[i][j] = (s.charAt(j) == 'G')?'R':s.charAt(j);
            }
        }
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        int cnt1 = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(vis1[i][j]) continue;
                cnt1++;
                vis1[i][j] = true;
                Queue<EntryPair> queue = new ArrayDeque<>();
                queue.add(new EntryPair(i,j));
                while(!queue.isEmpty()) {
                    EntryPair pair = queue.remove();
                    for(int dir=0;dir<4;dir++) {
                        int nx = pair.x + dx[dir];
                        int ny = pair.y + dy[dir];
                        if(nx < 0 || ny < 0 || nx >=n || ny >= n) continue;
                        if(vis1[nx][ny] || arr[nx][ny] != arr[pair.x][pair.y]) continue;
                        vis1[nx][ny] = true;
                        queue.add(new EntryPair(nx,ny));
                    }
                }
            }
        }

        int cnt2 = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(vis2[i][j]) continue;
                cnt2++;
                vis2[i][j] = true;
                Queue<EntryPair> queue = new ArrayDeque<>();
                queue.add(new EntryPair(i,j));
                while(!queue.isEmpty()) {
                    EntryPair pair = queue.remove();
                    for(int dir=0;dir<4;dir++) {
                        int nx = pair.x + dx[dir];
                        int ny = pair.y + dy[dir];
                        if(nx < 0 || ny < 0 || nx >=n || ny >= n) continue;
                        if(vis2[nx][ny] || color_arr[nx][ny] != color_arr[pair.x][pair.y]) continue;
                        vis2[nx][ny] = true;
                        queue.add(new EntryPair(nx,ny));
                    }
                }
            }
        }
        bw.write(cnt1 + " " + cnt2);
        bw.flush();
        bw.close();

    }

    public int bfs(char[][] arr, boolean[][] vis, int n) {
        int ans = 0;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(vis[i][j]) continue;
                vis[i][j] = true;
                ans++;
                Queue<EntryPair> queue = new ArrayDeque<>();
                queue.add(new EntryPair(i,j));

                while (!queue.isEmpty()) {
                    EntryPair pair = queue.remove();
                    for(int dir=0;dir<4;dir++) {
                        int nx = pair.x + dx[dir];
                        int ny = pair.y + dy[dir];

                        if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                        if(vis[nx][ny] || arr[nx][ny] != arr[pair.x][pair.y]) continue;
                        vis[nx][ny] = true;
                        queue.add(new EntryPair(nx,ny));
                    }
                }
            }
        }

        return ans;
    }
    public void color_blindness_10026_answer(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[102][102];
        boolean[][] vis = new boolean[102][102];

        for(int i=0;i<n;i++) {
            String s = br.readLine();
            for(int j=0;j<n;j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        int not_g = bfs(arr,vis,n);

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
                vis[i][j] = false;
            }
        }


        int g = bfs(arr,vis,n);

        bw.write(not_g + " " + g);
        bw.flush();
        bw.close();

    }
}
class EntryPair {
    int x;
    int y;

    public EntryPair(int x, int y)  {
        this.x = x;
        this.y = y;
    }
}
public class Algorithm0120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Test0120 test0120 = new Test0120();
        test0120.color_blindness_10026_answer(br,bw);
    }
}


