package org.exercise.blobs.impl;

import java.io.InputStream;

import org.exercise.blobs.BlobIOService;

import com.azure.core.util.BinaryData;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

public class DefaultBlobIOService implements BlobIOService
{

	private final BlobServiceClient blobServiceClient;

	public DefaultBlobIOService() {
		final String connectStr = "DefaultEndpointsProtocol=http;AccountName=devstoreaccount1;AccountKey=Eby8vdM02xNOcqFlqUwJPLlmEtlCDXJ1OUzFT50uSRZ6IFsuFq2UVErCz4I6tq/K1SZFPTOtr/KBHBeksoGMGw==;BlobEndpoint=http://127.0.0.1:10000/devstoreaccount1/orders;";
		this.blobServiceClient = new BlobServiceClientBuilder().connectionString(connectStr).buildClient();
	}

	@Override
	public void createBlob(final String containerName, final String blobName, final InputStream data)
	{
		final BlobClient blobClient = blobServiceClient.getBlobContainerClient(containerName).getBlobClient(blobName);
		blobClient.upload(BinaryData.fromStream(data));
	}

	@Override
	public InputStream readBlob(final String containerName, final String blobName)
	{
		return null;
	}

	@Override
	public void updateBlob(final String containerName, final String blobName, final InputStream data)
	{

	}

	@Override
	public void deleteBlob(final String containerName, final String blobName)
	{

	}

	@Override
	public boolean blobExists(final String containerName, final String blobName)
	{
		return false;
	}
}
