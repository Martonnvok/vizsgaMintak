import NavigacioView from "../../view/Dives/nav/NavigacioView.js";
import NavModel from "../../model/Nav/NavModel.js";

class Ncontroller {
  #nav
  constructor() {
    this.#nav = new NavModel();
    new NavigacioView($(".navigacioSav"), this.#nav.getleiro());
  }

  
}
export default Ncontroller;