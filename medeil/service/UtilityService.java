
package com.medeil.service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.medeil.repository.DrugRepository;
//import com.medeil.repository.DrugRepository;
import com.medeil.repository.UtilityRepository;

/**
 * @author Ajith AK
 */
@SuppressWarnings("rawtypes")
@Service
public class UtilityService {

	@Autowired
	private UtilityRepository utilityRepository;

	@Autowired
	private DrugRepository drugRepository;

	@PersistenceContext
	private EntityManager em;

	Query query;

	private static Logger logger = LogManager.getLogger();

	private final Path rootLocation = Paths.get("drugPicture");

	public List getCountry() throws Exception {
		return utilityRepository.getCountry();
	}

	public List getState(int countryid) throws Exception {
		return utilityRepository.getState(countryid);
	}

	public List getCountrycode(int countryid) throws Exception {
		return utilityRepository.getCountrycode(countryid);
	}

	public List getCity(int sid) throws Exception {
		return utilityRepository.getCity(sid);
	}

	/***** Upload Files ****/
	@Transactional
	public void store(MultipartFile[] file) throws Exception {
		try {
			// Integer productId = drugRepository.maxInsurence();
			Integer productId = 0;
			int proId = productId;
			String pid = productId.toString() + "_";
			for (MultipartFile uploadedFile : file) {
				String insuQuery = "INSERT INTO medc_productmaster.medc_custprdphoto (DrugProductRefID, PhotoName) VALUES ( ? , ?)";
				query = em.createNativeQuery(insuQuery);
				query.setParameter(1, proId);
				query.setParameter(2, uploadedFile.getOriginalFilename());
				query.executeUpdate();
				if (!Files.exists(rootLocation)) {
					try {
						Files.createDirectories(rootLocation);
						Files.copy(uploadedFile.getInputStream(),
								this.rootLocation.resolve(pid.concat(uploadedFile.getOriginalFilename()).trim()));
					} catch (IOException e) {
						System.out.println("Exception in Create directories : " + e);
						logger.error("Exception in Create Directories : " + e);
						e.printStackTrace();
					}
				} else {
					Files.copy(uploadedFile.getInputStream(),
							this.rootLocation.resolve(pid.concat(uploadedFile.getOriginalFilename()).trim()));
				}
			}
		} catch (Exception e) {
			logger.error("Exception in Method : store-->File Upload : " + e);
			// throw new RuntimeException("FAIL!");
			throw new Exception(e);
		}
	}

	/*************************************************************/
	@Transactional
	public void storeModify(MultipartFile[] file, Integer id) throws Exception {
		try {
			int proId = id;
			String pid = id.toString() + "_";
			for (MultipartFile uploadedFile : file) {
				String insuQuery = "INSERT INTO medc_productmaster.medc_custprdphoto (DrugProductRefID, PhotoName) VALUES ( ? , ?)";
				query = em.createNativeQuery(insuQuery);
				query.setParameter(1, proId);
				query.setParameter(2, uploadedFile.getOriginalFilename());
				query.executeUpdate();
				if (!Files.exists(rootLocation)) {
					try {
						Files.createDirectories(rootLocation);
						Files.copy(uploadedFile.getInputStream(),
								this.rootLocation.resolve(pid.concat(uploadedFile.getOriginalFilename()).trim()));
					} catch (IOException e) {
						logger.error("Exception in Create Directories : " + e);
						e.printStackTrace();
					}
				} else {
					Files.copy(uploadedFile.getInputStream(),
							this.rootLocation.resolve(pid.concat(uploadedFile.getOriginalFilename()).trim()));
				}
			}
		} catch (Exception e) {
			logger.error("Exception in Method : storeModify-->File Upload : " + e);
			// throw new RuntimeException("FAIL!");
			throw new Exception(e);
		}
	}

	/***** Get UploadedFiles ****/

	public Map<String, String> getuploadedImage(String id) throws IOException {
		Map<String, String> jsonMap = new HashMap<>();
		List fileName = null;
		try {
			String reqId = id + "_";
			fileName = utilityRepository.getFilename(id);
			for (int i = 0; i < fileName.size(); i++) {
				File file = new File(rootLocation + "/" + reqId.concat((String) fileName.get(i)));
				String encodeImage = Base64.getEncoder().withoutPadding()
						.encodeToString(Files.readAllBytes(file.toPath()));
				jsonMap.put("content", encodeImage);
			}
		} catch (Exception e) {
			System.out.println("Exception in Method: getImage : " + e);
			logger.error("Exception in Method: getImage : " + e);
			throw new IOException(e);
		}
		return jsonMap;
	}

	/*************************************************************/

	public List getVat() throws Exception {

		return utilityRepository.getVat();
	}

	public List getGst() throws Exception {

		return utilityRepository.getGst();
	}

	public List getSgst() throws Exception {

		return utilityRepository.getSgst();
	}

	public List getCgst() throws Exception {

		return utilityRepository.getCgst();
	}

	public List getIgst() throws Exception {

		return utilityRepository.getIgst();
	}

	public List getMacs() throws Exception {
		ArrayList<String> ls = new ArrayList<String>();
		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
			System.out.println("HostName: \t" + InetAddress.getLocalHost().getHostName());
			System.out.println("------------------------------------------\n");
			System.out.println("Current IP address : " + ip.getHostAddress());
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);

			byte[] mac = network.getHardwareAddress();

			System.out.print("Current MAC address : ");

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
			}
			System.out.println(sb.toString());
			String a1 = InetAddress.getLocalHost().getHostName();
			String a2 = ip.getHostAddress();
			String a3 = sb.toString();
			ls.add(a1);
			ls.add(a2);
			ls.add(a3);

		} catch (UnknownHostException e) {

			e.printStackTrace();
			throw new Exception(e);

		} catch (SocketException e) {

			e.printStackTrace();
			throw new Exception(e);
		}
		return ls;
	}

	// Mani
	@Transactional
	public List getAutoincrement1() throws Exception {
		List ls = null;
		String a1 = "PurchaseOrder";
		// try {
		String q = "Call medc_purchase.pro_getAutoIncrement( ? )";
		query = em.createNativeQuery(q);
		query.setParameter(1, a1);
		ls = query.getResultList();
		System.out.println("SutoIncrement  :" + ls);
		// } catch (Exception e) {
		// System.out.println("getAutoincrements :" + e);
		// }

		return ls;
	}

	public List getCompany() throws Exception {
		return utilityRepository.getCompany();
	}

	public List getCompany(int comp) throws Exception {
		return utilityRepository.getCompany(comp);
	}

	public List getCountryMap() throws Exception {
		return utilityRepository.getCountryMap();
	}

	public List getSample(String term) throws Exception {
		return utilityRepository.getSample(term);
	}

	public List getAllCompany() throws Exception {
		return utilityRepository.getAllCompany();
	}

	@Transactional
	public List getAutoincrement() throws Exception {
		List ls = null;
		String a1 = "PurchaseOrder";
		// try {
		String q = "Call medc_purchase.pro_getPOAutoIncrement( ? )";
		query = em.createNativeQuery(q);
		query.setParameter(1, a1);
		ls = query.getResultList();
		System.out.println("SutoIncrement  :" + ls);
		// } catch (Exception e) {
		// System.out.println("getAutoincrements :" + e);
		// }

		return ls;
	}

}
