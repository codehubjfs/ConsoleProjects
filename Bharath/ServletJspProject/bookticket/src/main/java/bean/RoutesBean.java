package bean;

public class RoutesBean {

		private int index;
		private String source,destination;
		private int duration,distance;


		public RoutesBean() {
		}

		public RoutesBean(int index, String source, String destination, int duration, int distance) {
			this.index = index;
			this.source = source;
			this.destination = destination;
			this.duration = duration;
			this.distance = distance;
		}

		public RoutesBean(String source, String destination, int duration, int distance) {
			this.source = source;
			this.destination = destination;
			this.duration = duration;
			this.distance = distance;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getDestination() {
			return destination;
		}

		public void setDestination(String destination) {
			this.destination = destination;
		}

		public int getDuration() {
			return duration;
		}

		public void setDuration(int duration) {
			this.duration = duration;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "\nRoutesBean [index=" + index + ", source=" + source + ", destination=" + destination + ", duration="
					+ duration + ", distance=" + distance + "]";
		}
		}
