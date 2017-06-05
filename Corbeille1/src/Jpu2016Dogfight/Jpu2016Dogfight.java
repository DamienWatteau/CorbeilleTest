import jpu2016.dogfight.controller.DogfightController;
import jpu2016.dogfight.model.Cloud;
import jpu2016.dogfight.model.Dimension;
import jpu2016.dogfight.model.Direction;
import jpu2016.dogfight.model.DogfightModel;
import jpu2016.dogfight.model.Plane;
import jpu2016.dogfight.model.Position;
import jpu2016.dogfight.view.DogfightView;

public abstract class Jpu2016Dogfight {

	public static void main(final String[] args) {
		final DogfightModel dogfightModel = new DogfightModel();

		dogfightModel.buildArea(new Dimension(1000, 700));
		dogfightModel.addMobile(new Cloud(Direction.LEFT, new Position(200, 200)));
		dogfightModel.addMobile(new Plane(0, Direction.RIGHT, new Position(10, 60), "F4U"));
		dogfightModel.addMobile(new Plane(1, Direction.RIGHT, new Position(10, 590), "Zero"));
		dogfightModel.addMobile(new Cloud(Direction.LEFT, new Position(100, 100)));
		dogfightModel.addMobile(new Cloud(Direction.LEFT, new Position(400, 400)));

		final DogfightController dogfightController = new DogfightController(dogfightModel);
		final DogfightView dogfightView = new DogfightView(dogfightController, dogfightModel, dogfightModel);
		dogfightController.setViewSystem(dogfightView);
		dogfightController.play();
	}

}
