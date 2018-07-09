package com.javaapi.test.jrebel;




public class ParseLicense {
//	@Test
//	public void parseLicenseFile() {
//		Object localObject1 = null;
//		try {
//			System.out.println("start to get lic file.");
//			File localFile2 = new File(
//					"C:\\Users\\hncw\\Desktop\\自制环境\\new2.lic");
//			Assert.assertNotNull(localFile2);
//
//			System.out.println("start to get objectInputStream.");
//			localObject1 = new ObjectInputStream(new BufferedInputStream(
//					new FileInputStream(localFile2)));
//			Assert.assertNotNull(localObject1);
//
//			System.out.println("start to get userLicense.");
//			UserLicense localUserLicense1 = (UserLicense) ((ObjectInputStream) localObject1)
//					.readObject();
//			Assert.assertNotNull(localUserLicense1);
//
//			System.out.println("start to get ObjectInputStream2.");
//			ObjectInputStream localObjectInputStream = new ObjectInputStream(
//					new ByteArrayInputStream(localUserLicense1.getLicense()));
//			Assert.assertNotNull(localObjectInputStream);
//
//			System.out.println("start to get localMap.");
//			Map localMap = (Map) localObjectInputStream.readObject();
//			Assert.assertNotNull(localMap);
//
//			System.out.println("start tot output value.");
//			for (Iterator<?> iter = localMap.keySet().iterator(); iter
//					.hasNext();) {
//				String key = (String) iter.next();
//				System.out.println("key: " + key + ", value: "
//						+ localMap.get(key));
//			}
////			changeLic(localUserLicense1, localMap);
//		} catch (Exception e) {
//			e.printStackTrace();
//			Assert.fail("faile to parse license. ");
//		} finally {
//			if (localObject1 != null) {
//				try {
//					((ObjectInputStream) localObject1).close();
//				} catch (IOException localIOException12) {
//				}
//			}
//		}
//
//	}
//
//	private void changeLic(UserLicense localUserLicense1, Map localMap)
//			throws IOException, ClassNotFoundException, FileNotFoundException {
//		ObjectInputStream localObjectInputStream;
//		System.out.println("start to change date.");
//		Calendar cal = new GregorianCalendar(2025, 01, 01);
//		localMap.put("validUntil", cal.getTime());
//		localMap.put("name", "wwwkkk");
//
//		System.out.println("start to set a new date to license.");
//		ByteArrayOutputStream out1 = new ByteArrayOutputStream();
//		ObjectOutputStream out2 = new ObjectOutputStream(out1);
//		out2.writeObject(localMap);
//		out1.toByteArray();
//		localUserLicense1.setLicense(out1.toByteArray());
//		out1.close();
//		out2.close();
//
//		System.out.println("start to get ObjectInputStream2.");
//		localObjectInputStream = new ObjectInputStream(
//				new ByteArrayInputStream(localUserLicense1.getLicense()));
//		Assert.assertNotNull(localObjectInputStream);
//
//		System.out.println("start to get localMap.");
//		localMap = (Map) localObjectInputStream.readObject();
//		Assert.assertNotNull(localMap);
//
//		for (Iterator<?> iter = localMap.keySet().iterator(); iter
//				.hasNext();) {
//			String key = (String) iter.next();
//			System.out.println("key: " + key + ", value: "
//					+ localMap.get(key));
//		}
//
//		String newLicenseFile = "C:\\Users\\hncw\\Desktop\\自制环境\\new2.lic";
//		ObjectOutputStream out3 = new ObjectOutputStream(
//				new BufferedOutputStream(new FileOutputStream(
//						newLicenseFile)));
//		out3.writeObject(localUserLicense1);
//		out3.close();
//	}
}