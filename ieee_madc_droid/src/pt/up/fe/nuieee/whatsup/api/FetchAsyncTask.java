package pt.up.fe.nuieee.whatsup.api;

import android.os.AsyncTask;

public class FetchAsyncTask<T> extends AsyncTask<ServerAPI.Actions, Void, T> {

	private AsyncTaskHandler<T> mHandler;
	private Exception mError;
	private String[] data;

	public FetchAsyncTask(AsyncTaskHandler<T> handler, String... data) {
		this.mHandler = handler;
		this.data = data;
	}
	
	@Override
	protected void onPostExecute(T result) {
		
		if (mError == null) {
			mHandler.onSuccess(result);
		}
		else {
			mHandler.onFailure(mError);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected T doInBackground(ServerAPI.Actions... params) {
		try {
			switch (params[0]) {
			case authenticateStudentBranch:
				return (T) ServerAPI.authenticateStudentBranch((String) data[0], (String) data[1]);
			case getEvents:
				return (T) ServerAPI.getEvents();
			case getTopSBs:
				return (T) ServerAPI.getTopSBs();
			case newStudentBranch:
				return (T) ServerAPI.createSB(data[0], data[1], data[2], data[3]);
			case newEvent:
				return (T) ServerAPI.newEvent(data[0], data[1], data[2], data[3], data[4], data[5]);
			case getEventsOfSB:
				return (T) ServerAPI.getEventsOfSB(data[0]);
			default:
			
			}
		} catch (Exception e) {
			mError = e;
		}
		return null;
	}

}
