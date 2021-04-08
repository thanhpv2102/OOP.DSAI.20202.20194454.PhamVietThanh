package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

class DiscWrapper {
	DigitalVideoDisc dvd;

	DiscWrapper(DigitalVideoDisc dvd) {
		this.dvd = dvd;

	}
}

public class TestPassingParameter {
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		DiscWrapper dvd1 = new DiscWrapper(jungleDVD);
		DiscWrapper dvd2 = new DiscWrapper(cinderellaDVD);

		swap(dvd1, dvd2);
		System.out.println("jungle dvd title: " + dvd1.dvd.getTitle());
		System.out.println("cinderella dvd title: " + dvd2.dvd.getTitle());

		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + dvd1.dvd.getTitle());
	}


	public static void swap(DiscWrapper dvd1, DiscWrapper dvd2) {
		DigitalVideoDisc temp = dvd1.dvd;
		dvd1.dvd = dvd2.dvd;
		dvd2.dvd = temp;
	}

	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}
