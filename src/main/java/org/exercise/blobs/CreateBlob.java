package org.exercise.blobs;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

public class CreateBlob
{
	private static final Logger logger = LoggerFactory.getLogger(CreateBlob.class);

	final String connectStr = "DefaultEndpointsProtocol=http;AccountName=devstoreaccount1;AccountKey=Eby8vdM02xNOcqFlqUwJPLlmEtlCDXJ1OUzFT50uSRZ6IFsuFq2UVErCz4I6tq/K1SZFPTOtr/KBHBeksoGMGw==;BlobEndpoint=http://127.0.0.1:10000/devstoreaccount1/orders;";
	final String containerName = "orders";
	final String blobName = "orders-001";
	BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectStr).buildClient();

	public CreateBlob(final BlobServiceClient blobServiceClient)
	{
		this.blobServiceClient = blobServiceClient;
	}

	public void createBlobFromJsonFile(final String jsonFilePath, final String blobName)
	{
		final BlobClient blobClient = blobServiceClient.getBlobContainerClient(containerName).getBlobClient(blobName);

		if (Boolean.FALSE.equals(blobServiceClient.getBlobContainerClient(containerName).getBlobClient("orders-001").exists()))
		{
			final String jsonContent = readJsonFile(jsonFilePath);
			if (jsonContent != null)
			{
				final InputStream dataStream = new ByteArrayInputStream(jsonContent.getBytes(StandardCharsets.UTF_8));
				blobClient.upload(dataStream, jsonContent.length());
			}
			else
			{
				logger.error("jsonContent is null");
			}
		}
		else
		{
			logger.info("Blob exist");
		}
	}

	private String readJsonFile(final String jsonFilePath)
	{
		try
		{
			return new String(Files.readAllBytes(Paths.get(jsonFilePath)));
		}
		catch (final Exception e)
		{
			logger.error("Error reading file: {}", jsonFilePath, e);
			return null;
		}
	}
}
