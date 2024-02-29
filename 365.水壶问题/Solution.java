class Solution {
    public Queue<State> queue = new LinkedList<>();
    public Set<State> visited = new HashSet<>();
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(targetCapacity == 0){return true;}
        if(targetCapacity > jug1Capacity + jug2Capacity){
            return false;
        }
        queue.offer(new State(0 , 0));
        visited.add(new State(0 , 0));
        while(!queue.isEmpty()){
            State cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            if(x == targetCapacity || y == targetCapacity || x + y == targetCapacity){
                return true;
            }
            List<State> next = getNext(x,y,jug1Capacity,jug2Capacity);
            for(State nextState : next){
                addState(nextState);
            }
        }
        return false;
    }

    private class State{
        public int x;
        public int y;

        public State(int x,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State state = (State) o;
            return x == state.x &&
                    y == state.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private void addState(State newState) {
        if (!visited.contains(newState)) {
            queue.offer(newState);
            visited.add(newState);
        }
    }

    public List<State> getNext(int x,int y,int jug1Capacity,int jug2Capacity){
        List<State> next = new ArrayList<>();
        if(x < jug1Capacity){next.add(new State(jug1Capacity, y));}
        if(y < jug2Capacity){next.add(new State(x, jug2Capacity));}
        if(x > 0){next.add(new State(0, y));}
        if(y > 0){next.add(new State(x, 0));}
        if(x - (jug2Capacity - y) >= 0){next.add(new State(x - (jug2Capacity - y), jug2Capacity));}
        if(y - (jug1Capacity - x) >= 0){next.add(new State(jug1Capacity, y - (jug1Capacity - x)));}
        if(x + y <= jug1Capacity){next.add(new State(x + y, 0));}
        if(x + y <= jug2Capacity){next.add(new State(0, x + y));}
        return next;
    }
}
