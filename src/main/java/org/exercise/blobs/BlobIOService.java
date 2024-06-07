package org.exercise.blobs;

import java.io.InputStream;

public interface BlobIOService
{
	void createBlob(String containerName, String blobName, InputStream data);
	InputStream readBlob(String containerName, String blobName);
	void updateBlob(String containerName, String blobName, InputStream data);
	void deleteBlob(String containerName, String blobName);
	boolean blobExists(String containerName, String blobName);
}
