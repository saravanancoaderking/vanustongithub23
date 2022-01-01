package com.medeil.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.Warehouse;
import com.medeil.repository.WarehouseRepository;

/**
 * @author
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class WarehouseServices {

	@Autowired
	WarehouseRepository warehouserepository;

	public List<Warehouse> getAll() throws Exception {
		List<Warehouse> list = new ArrayList<>();
		Iterable<Warehouse> warehouse = warehouserepository.findAll();

		warehouse.forEach(list::add);
		return list;
	}

	public List editState(int id) throws Exception {
		Warehouse whstate = warehouserepository.findById(id);
		return warehouserepository.geteditState(whstate.getCountry());
	}

	public List compeditCity(int id) throws Exception {
		Warehouse whstate = warehouserepository.findById(id);
		return warehouserepository.geteditCity(whstate.getState());
	}

	public Warehouse postWarehouse(Warehouse warehouse) throws Exception {
		// try {
		warehouse.getId();
		System.out.println("inside service");
		warehouserepository.save(warehouse);
		System.out.println("inside service1");
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		return warehouse;
	}

	public int accessid(long id) throws Exception {
		return warehouserepository.accessid(id);
	}

	public Warehouse updateWarehouse(Warehouse warehouse, Integer id) throws Exception {
		warehouse.setId(id);
		System.out.println(warehouse.getId());
		warehouserepository.save(warehouse);
		return warehouse;
	}

	public void deleteWarehouse(long id) throws Exception {
		warehouserepository.deleteById(id);
	}

	public List country() throws Exception {
		return warehouserepository.country();
	}

	public List State(long id) throws Exception {
		return warehouserepository.State(id);
	}

	public List city(long id) throws Exception {
		return warehouserepository.city(id);
	}

	public List viewwarehouse(Warehouse warehouse) throws Exception {
		// TODO Auto-generated method stub
		return warehouserepository.view(warehouse.getCompanyrefid(), warehouse.getBranchrefid(), warehouse.getLocname(),
				warehouse.getLocrefid());
	}

	public List editWarehouse(Integer id, Integer cid, Integer bid, Integer locname, Integer locrefid)
			throws Exception {

		return warehouserepository.editWarehouse(id, cid, bid, locname, locrefid);
	}

	public boolean savewarehous(Warehouse warehouse) throws Exception {
		boolean flag = false;
		// try {
		System.out.println("inside service" + warehouse.getCity());
		warehouserepository.save(warehouse);
		System.out.println("inside service1");
		flag = true;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		return flag;

	}
}