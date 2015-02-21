package bloomberg;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class BloombergConnection {
	public KeyStore keyStore = KeyStore.getInstance("JKS");
	public KeyStore trustStore = KeyStore.getInstance("JKS");
	public InputStream ksis;
	public InputStream tsis;
	public TrustManagerFactory tmf = TrustManagerFactory
			.getInstance(TrustManagerFactory.getDefaultAlgorithm());
	public KeyManagerFactory kmf = KeyManagerFactory
			.getInstance(KeyManagerFactory.getDefaultAlgorithm());
	public SSLContext ctx;

	public BloombergConnection() throws KeyStoreException,
			NoSuchAlgorithmException, CertificateException, IOException,
			UnrecoverableKeyException {
		String trustStorePath = "";
		String keyStorePath = "";
		ksis = ClassLoader.getSystemResourceAsStream(keyStorePath);
		keyStore.load(ksis, "qqqqqq".toCharArray());
		kmf.init(keyStore, "qqqqqq".toCharArray());

		tsis = ClassLoader.getSystemResourceAsStream(trustStorePath);
		trustStore.load(tsis, "qqqqqq".toCharArray());
		tmf.init(trustStore);

	}
}
