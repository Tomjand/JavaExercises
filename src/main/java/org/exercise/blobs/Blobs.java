package org.exercise.blobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azure.core.util.BinaryData;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobItem;

public class Blobs
{
	private static final Logger logger = LoggerFactory.getLogger(Blobs.class);
	final String connectStr = "DefaultEndpointsProtocol=http;AccountName=devstoreaccount1;AccountKey=Eby8vdM02xNOcqFlqUwJPLlmEtlCDXJ1OUzFT50uSRZ6IFsuFq2UVErCz4I6tq/K1SZFPTOtr/KBHBeksoGMGw==;BlobEndpoint=http://127.0.0.1:10000/devstoreaccount1/orders;";

	final BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectStr).buildClient();
	final String containerName = "orders";

	public void start()
	{
		System.out.println("=============== Blobs: ==============");

		final CreateBlob blob = new CreateBlob(blobServiceClient);


		blobServiceClient.createBlobContainerIfNotExists("orders1");


		if (!blobServiceClient.getBlobContainerClient(containerName).exists())
		{
			blobServiceClient.createBlobContainer(containerName);
			logger.info("Container created : {}", containerName);
		}

		blob.createBlobFromJsonFile("src/main/resources/orders-001.json", "orders-002");

		printBlobList(blobServiceClient);
		printBlobByName("orders-002");
	}

	private void printBlobList(final BlobServiceClient blobServiceClient)
	{
		for (final BlobItem blobItem : blobServiceClient.getBlobContainerClient("orders").listBlobs())
		{
			System.out.println("\t" + "Blob List ::: ");
			logger.info("Blob list 1 : {}", blobItem.getName());
		}
	}

	private void printBlobByName(final String blobName)
	{
		final BlobClient blobClient = blobServiceClient.getBlobContainerClient(containerName).getBlobClient(blobName);

		if (blobClient.exists())
		{
			final BinaryData content = blobClient.downloadContent();
			System.out.println(content.toString());
		}
		else
		{
			System.out.println("Blob does not exist.");
		}
	}
}
