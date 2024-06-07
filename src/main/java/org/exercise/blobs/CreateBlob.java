package org.exercise.blobs;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azure.core.util.BinaryData;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

public class CreateBlob
{
	private static final Logger logger = LoggerFactory.getLogger(CreateBlob.class);

	final String connectStr = "DefaultEndpointsProtocol=http;AccountName=devstoreaccount1;AccountKey=Eby8vdM02xNOcqFlqUwJPLlmEtlCDXJ1OUzFT50uSRZ6IFsuFq2UVErCz4I6tq/K1SZFPTOtr/KBHBeksoGMGw==;BlobEndpoint=http://127.0.0.1:10000/devstoreaccount1/orders;";
	final String containerName = "orders";
	final String blobName = "orders-002";
	BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectStr).buildClient();

	public CreateBlob(final BlobServiceClient blobServiceClient)
	{
		this.blobServiceClient = blobServiceClient;
	}

	public void createBlobFromJsonFile(final String jsonFilePath, final String blobName)
	{
		final BlobClient blobClient = blobServiceClient.getBlobContainerClient(containerName).getBlobClient(blobName);

		if (Boolean.FALSE.equals(blobServiceClient.getBlobContainerClient(containerName).getBlobClient(blobName).exists()))
		{
			uploadJsonFile(blobClient, jsonFilePath);
		}
		else
		{
			logger.info("Blob exist");
		}
	}

	// pamietac zeby zamknac stream!!! finally close
	// try (InputStream inputStream = Files.newInputStream(sciezkaDoPliku)) { // ... } catch (IOException e) { e.printStackTrace(); }
	//inputStream do innej klasy - obsluga pliku stream
	private void uploadJsonFile(final BlobClient blobClient, final String jsonFilePath)
	{
		try (final InputStream inputStream = Files.newInputStream(Path.of(jsonFilePath)))
		{
			 blobClient.upload(BinaryData.fromStream(inputStream));
		}
		catch (final IOException e)
		{
			logger.error("Error reading file: {}", jsonFilePath, e);

		}

		//try
		//{
		//	//InputStream dataStream = new ByteArrayInputStream(jsonContent.getBytes(StandardCharsets.UTF_8));
		//	return Files.readAllBytes(Paths.get(jsonFilePath));
		//}
		//catch (final Exception e)
		//{
		//	logger.error("Error reading file: {}", jsonFilePath, e);
		//	return null;
		//}
	}
}
