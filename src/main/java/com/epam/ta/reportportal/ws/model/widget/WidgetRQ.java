/*
 * Copyright 2019 EPAM Systems
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.epam.ta.reportportal.ws.model.widget;

import com.epam.ta.reportportal.ws.annotations.In;
import com.epam.ta.reportportal.ws.model.SharableEntityRQ;
import com.epam.ta.reportportal.ws.model.ValidationConstraints;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Domain model object for creating and updating widget
 *
 * @author Aliaksei_Makayed
 */

@JsonInclude(Include.NON_NULL)
public class WidgetRQ extends SharableEntityRQ {

	@NotBlank
	@Size(min = ValidationConstraints.MIN_NAME_LENGTH, max = ValidationConstraints.MAX_WIDGET_NAME_LENGTH)
	private String name;

	@NotNull
	@JsonProperty(value = "widgetType", required = true)
	@In(allowedValues = { "oldLineChart", "investigatedTrend", "launchStatistics", "statisticTrend", "casesTrend", "notPassed",
			"overallStatistics", "uniqueBugTable", "bugTrend", "activityStream", "launchesComparisonChart", "launchesDurationChart",
			"launchesTable", "topTestCases", "flakyTestCases", "passingRateSummary", "passingRatePerLaunch", "productStatus",
			"mostTimeConsuming", "cumulative" })
	@ApiModelProperty(required = true, allowableValues = "oldLineChart, investigatedTrend, launchStatistics, statisticTrend,"
			+ " casesTrend, notPassed, overallStatistics, uniqueBugTable, bugTrend, activityStream, launchesComparisonChart,"
			+ " launchesDurationChart, launchesTable, topTestCases, flakyTestCases, passingRateSummary, passingRatePerLaunch,"
			+ " productStatus, mostTimeConsuming, cumulative")
	private String widgetType;

	@Valid
	@JsonProperty(value = "contentParameters")
	private ContentParameters contentParameters;

	@JsonProperty(value = "filterIds")
	private List<Long> filterIds;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	public String getWidgetType() {
		return widgetType;
	}

	public void setWidgetType(@NotNull String widgetType) {
		this.widgetType = widgetType;
	}

	public ContentParameters getContentParameters() {
		return contentParameters;
	}

	public void setContentParameters(ContentParameters contentParameters) {
		this.contentParameters = contentParameters;
	}

	public List<Long> getFilterIds() {
		return filterIds;
	}

	public void setFilterIds(List<Long> filterIds) {
		this.filterIds = filterIds;
	}

	@Override
	public String toString() {
		return "WidgetRQ{" + "name='" + name + '\'' + ", widgetType='" + widgetType + '\'' + ", contentParameters=" + contentParameters
				+ ", filterIds=" + filterIds + '}';
	}
}