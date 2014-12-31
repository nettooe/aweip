package com.aweip.jsf.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.aweip.jsf.services.CarService;
import com.aweip.model.entityes.Car;

@ManagedBean(name = "dtSelectionView")
@ViewScoped
public class ArquivosMB implements Serializable {
	private static final long serialVersionUID = 1744876218906903515L;

	private List<Car> cars1;
	private List<Car> cars2;
	private List<Car> cars3;
	private List<Car> cars4;
	private List<Car> cars5;
	private List<Car> cars6;
	private Car selectedCar;
	private List<Car> selectedCars;

	private String loren = "\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque pharetra odio justo, eget sagittis dolor tincidunt ut. Suspendisse id venenatis elit. Aenean tempor, tortor at gravida vestibulum, nibh nisi eleifend odio, in blandit urna tellus vel magna. Nam feugiat enim at risus dictum, id adipiscing lorem ultricies. Quisque metus urna, tristique vitae suscipit vel, suscipit et mauris. Integer vel massa ac turpis scelerisque dapibus. In venenatis nibh in velit iaculis, sed porttitor nunc hendrerit. Mauris tincidunt, nulla non scelerisque suscipit, augue nisl porta urna, vitae facilisis velit sapien at diam. Nulla in rhoncus elit, at ullamcorper sapien. Sed molestie, tortor eu hendrerit dapibus, dolor purus faucibus ligula, non auctor nulla ligula eu dolor. Vivamus interdum, odio in accumsan sodales, nisl dolor rutrum mauris, commodo laoreet urna orci in nisl. Integer elementum, velit eu venenatis convallis, dolor turpis fermentum est, ut hendrerit felis magna sit amet nibh. Etiam augue enim, volutpat eu dictum id, porta non dui.\nFusce tincidunt turpis a pulvinar tempus. Aliquam viverra lorem a enim bibendum porta. Vivamus venenatis turpis at lacus lacinia, sit amet interdum magna sagittis. Mauris quis metus sed justo porta venenatis. Praesent dui metus, facilisis eget feugiat ac, blandit in lorem. In hac habitasse platea dictumst. Sed consequat, est at rutrum sodales, nisl augue elementum sapien, vitae dapibus massa nisl id lacus. Sed pellentesque enim ac orci accumsan, quis venenatis enim viverra. Nunc eget augue non erat tristique accumsan. Duis ut magna lacinia velit feugiat sodales. Sed laoreet nisi in tortor malesuada elementum. Mauris auctor feugiat sodales. Donec nec magna quis erat vulputate fermentum a vitae massa. Aliquam erat volutpat. Nulla a felis ut tellus sollicitudin adipiscing quis at libero.\nSed molestie purus vestibulum, viverra eros sit amet, vestibulum augue. In et velit arcu. Fusce nec pharetra eros. Maecenas consequat pulvinar orci. In posuere, velit vel molestie tincidunt, nisl elit dapibus nunc, sed viverra eros massa ut libero. Nunc vel venenatis magna, eget ultrices lectus. Etiam posuere ante ut blandit bibendum. Aliquam a ipsum nec lectus ornare feugiat. Vestibulum vehicula vel mi eu fringilla. Quisque mollis est vitae tincidunt eleifend. Aliquam accumsan, orci eget dignissim ornare, enim enim luctus ligula, at pellentesque purus felis a risus. Quisque purus turpis, tempus vitae convallis sed, adipiscing eget arcu. Morbi in congue leo. Proin posuere, ligula dignissim ullamcorper gravida, erat purus malesuada enim, ut iaculis felis arcu in arcu. Vestibulum sagittis sollicitudin mi, non imperdiet arcu tristique at. Cras euismod nisi a fermentum gravida.\nPhasellus vulputate libero urna, quis commodo turpis vehicula sit amet. Sed tempus commodo urna vel mollis. Integer vel lacus ut nulla laoreet pulvinar fringilla vitae ligula. Mauris auctor erat quis suscipit lobortis. Proin eget diam id dui consectetur tincidunt. Quisque nec augue leo. Cras quis mollis ipsum. Proin est nibh, ornare sed nisi sit amet, dictum mattis turpis. Duis semper tellus lacus, vel sodales ligula feugiat id.\nIn venenatis posuere ligula, et adipiscing magna egestas sit amet. Pellentesque ac viverra nibh, suscipit adipiscing augue. Nunc massa libero, gravida quis commodo sed, mattis ut odio. Morbi id urna est. Duis id tortor diam. Donec at lacus facilisis, eleifend orci in, pharetra purus. Duis adipiscing porttitor leo a mollis. Maecenas mattis, odio vel condimentum rutrum, metus magna ornare ipsum, eu vehicula ipsum lacus ut felis. Nunc accumsan justo id adipiscing facilisis.\nInteger in velit eget magna porttitor lacinia at eget est. Integer sodales in libero sit amet sodales. Fusce pellentesque arcu a urna tristique auctor. Integer vel sodales augue. Donec rhoncus congue justo, id congue neque tempus sit amet. Nulla consequat sed enim vitae gravida. Aliquam vel auctor nunc. Ut in massa commodo, fermentum lorem eu, eleifend leo. Morbi purus magna, dictum ac tellus et, eleifend faucibus elit. Praesent diam risus, congue eu augue quis, porta congue turpis. Aliquam erat volutpat.\nPellentesque purus quam, tincidunt ac purus at, tincidunt vulputate dolor. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Suspendisse ut auctor orci. Maecenas vitae scelerisque purus, in pharetra lacus. Suspendisse vulputate imperdiet suscipit. Proin non convallis lorem, et sagittis purus. Suspendisse et accumsan purus, id pretium odio. Vivamus magna diam, tempor eget tortor ac, tempus mattis tortor. Curabitur ut consequat mi, ac commodo mauris. Mauris tincidunt, purus in pharetra consequat, massa lorem vehicula magna, et faucibus erat augue et ante.\nQuisque eu porttitor leo. Sed rhoncus vehicula consectetur. Fusce tincidunt neque eros, sed pharetra neque malesuada a. Pellentesque aliquet ante in elit faucibus mattis vestibulum sed velit. Etiam luctus pretium magna in tempor. Curabitur lacinia sem non enim sodales, eget condimentum metus blandit. Aliquam in ante tellus. Nunc vitae rutrum ligula. Vestibulum mattis laoreet turpis, interdum tincidunt quam. Duis sit amet est ac risus suscipit pellentesque. Vestibulum eget dapibus velit. Nam dignissim leo nec commodo porta. Maecenas at enim ultrices sapien convallis sagittis.\nNulla tempus mi ipsum, ut hendrerit arcu aliquam mattis. Nunc odio purus, feugiat eu diam nec, semper elementum lorem. Morbi id enim est. Mauris enim dui, ullamcorper nec porttitor id, dictum eget turpis. In vel rhoncus ipsum, fermentum semper eros. Ut egestas fermentum venenatis. Nunc rhoncus, dui eu fermentum tempor, nulla nulla scelerisque diam, vitae faucibus purus ipsum vel arcu. In congue, ipsum sit amet dictum venenatis, elit ipsum pulvinar justo, ac vehicula tortor tortor ut velit. Ut vitae commodo mi. Morbi malesuada et urna vitae porttitor. Nulla ut nisl massa. Donec in fringilla velit. Aenean ut tincidunt velit. Integer egestas porttitor feugiat. Phasellus sed tellus velit. Nam quis sem laoreet, consectetur libero ac, aliquet ante.\nAenean adipiscing nulla eu dui eleifend, eget congue ipsum rhoncus. Maecenas non pharetra odio, vitae sollicitudin dolor. Mauris varius nisi ac risus dignissim sodales. Suspendisse a ultricies enim. Suspendisse sed eros vel enim scelerisque facilisis vel nec dolor. Integer eget nibh et orci iaculis elementum. Cras et quam in felis malesuada porttitor. Nulla facilisi.\nFusce ultricies nibh dolor, quis scelerisque dolor ultrices eu. Mauris a enim sit amet sem fringilla aliquet. Cras sodales massa non leo ultrices, a tincidunt libero pellentesque. Mauris vitae ipsum et ipsum porta sollicitudin. Curabitur eu neque hendrerit, tincidunt est blandit, blandit magna. Aliquam urna sem, feugiat nec cursus vel, molestie eu purus. Vivamus tempus dui nulla, vel laoreet dolor consectetur ac. Morbi non justo id felis lobortis faucibus ac at lorem. Morbi dui nibh, volutpat sed enim eu, varius aliquam erat. Integer faucibus porttitor hendrerit. Vivamus in orci nibh. Aliquam imperdiet, sapien in varius molestie, ligula dolor luctus ante, et interdum tellus lectus sed orci. Integer diam libero, luctus id facilisis in, tincidunt eget mauris. \nSed a nunc sapien. Nunc pulvinar augue vel volutpat fermentum. Nam convallis tristique tellus congue malesuada. Integer nec diam quam. Ut at massa ligula. Aenean ut mi eu purus congue volutpat. Sed velit turpis, auctor at diam id, eleifend egestas risus.\n";

	private List<String> palavrasChave = new ArrayList<String>();
	private String palavraChave = new String();

	@ManagedProperty("#{carService}")
	private CarService service;

	@PostConstruct
	public void init() {
		cars1 = service.createCars(10);
		cars2 = service.createCars(10);
		cars3 = service.createCars(10);
		cars4 = service.createCars(10);
		cars5 = service.createCars(10);
		cars6 = service.createCars(10);

		palavrasChave.add("Sustentabilidade".toLowerCase());
		palavrasChave.add("Economia".toLowerCase());
		palavrasChave.add("política".toLowerCase());
		palavrasChave.add("democracia".toLowerCase());
		palavrasChave.add("recursos minerais".toLowerCase());
		palavrasChave.add("flora".toLowerCase());
		palavrasChave.add("amazônia".toLowerCase());
		palavrasChave.add("Brasil".toLowerCase());
		palavrasChave.add("biopirataria".toLowerCase());

	}

	public List<Car> getCars1() {
		return cars1;
	}

	public List<Car> getCars2() {
		return cars2;
	}

	public List<Car> getCars3() {
		return cars3;
	}

	public List<Car> getCars4() {
		return cars4;
	}

	public List<Car> getCars5() {
		return cars5;
	}

	public List<Car> getCars6() {
		return cars6;
	}

	public void setService(CarService service) {
		this.service = service;
	}

	public Car getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(Car selectedCar) {
		this.selectedCar = selectedCar;
	}

	public List<Car> getSelectedCars() {
		return selectedCars;
	}

	public void setSelectedCars(List<Car> selectedCars) {
		this.selectedCars = selectedCars;
	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Car Selected",
				((Car) event.getObject()).getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent event) {
		FacesMessage msg = new FacesMessage("Car Unselected",
				((Car) event.getObject()).getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String getLoren() {
		return loren;
	}

	public void setLoren(String loren) {
		this.loren = loren;
	}

	public List<String> getPalavrasChave() {
		java.util.Collections.sort(this.palavrasChave);
		return palavrasChave;
	}

	public void setPalavrasChave(List<String> palavrasChave) {
		this.palavrasChave = palavrasChave;
	}

	public void addPalavraChave() {
		if (!this.palavraChave.isEmpty()) {
			this.palavrasChave.add(this.palavraChave.toLowerCase());
			this.palavraChave = new String();
		}
	}

	public void removePalavraChave(String palavra) {
		if (!palavra.isEmpty() && this.palavrasChave.contains(palavra.toLowerCase())) {
			this.palavrasChave.remove(palavra.toLowerCase());
		}
	}

	public String getPalavraChave() {
		return palavraChave;
	}

	public void setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
	}

}